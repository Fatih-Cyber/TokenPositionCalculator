package com.example.tokenpositioncalculator.serviceimpl;

import com.example.tokenpositioncalculator.dto.AccountDTO;
import com.example.tokenpositioncalculator.dto.HoldingDTO;
import com.example.tokenpositioncalculator.dto.PositionDTO;
import com.example.tokenpositioncalculator.entity.Account;
import com.example.tokenpositioncalculator.entity.Currency;
import com.example.tokenpositioncalculator.entity.Holding;
import com.example.tokenpositioncalculator.entity.Position;
import com.example.tokenpositioncalculator.mapper.MapperUtil;
import com.example.tokenpositioncalculator.model.CsvTx;
import com.example.tokenpositioncalculator.model.SubTx;
import com.example.tokenpositioncalculator.repository.CurrencyRepository;
import com.example.tokenpositioncalculator.repository.HoldingRepository;
import com.example.tokenpositioncalculator.repository.PositionRepository;
import com.example.tokenpositioncalculator.service.AccountService;
import com.example.tokenpositioncalculator.service.CsvReader;
import com.example.tokenpositioncalculator.service.PositionBuiderService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PositionBuilderServiceImpl implements PositionBuiderService {
    private final AccountService accountService;
    private final HoldingRepository holdingRepository;
    private final PositionRepository positionRepository;
    private final CurrencyRepository currencyRepository;
    private  final MapperUtil mapperUtil;

    public PositionBuilderServiceImpl(AccountService accountService, HoldingRepository holdingRepository, PositionRepository positionRepository, CurrencyRepository currencyRepository, MapperUtil mapperUtil) {
        this.accountService = accountService;
        this.holdingRepository = holdingRepository;
        this.positionRepository = positionRepository;
        this.currencyRepository = currencyRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public void buildPositionsFromCsv(String fileName) {
        //read csv into a List
        // CsvTx= String txHash;timeStamp;Account; ArrayList<SubTx> subTransactionList;
        List<CsvTx> trx = CsvReader.readTransactionsCsv(fileName);
        // iterate
        for (CsvTx csvTx : trx) {
            //check if account exists if no create new account
            AccountDTO accountDTO = accountService.findByAccountNo(csvTx.getAccount());
            if (accountDTO.getAccountNo() == null) accountDTO.setAccountNo(csvTx.getAccount());
            for (SubTx subTx : csvTx.getSubTransactionList()) {
                  // Bu sembol ile holding var mı varsa holding i getir yok ise yeni holding create et
                 if (accountDTO.getHoldings()!=null && accountDTO.getHoldings().size()>0){
                     HoldingDTO holding =accountDTO.getHoldings().stream().filter(h -> h.getCurrency().getCode().equals(subTx.getSymbol())).findFirst().orElse(mapperUtil.convert(createHolding(currencyRepository.findByCode(subTx.getSymbol()), mapperUtil.convert(accountDTO,new Account())), new HoldingDTO()));
                     if(subTx.getType().equalsIgnoreCase("incoming")) {

                         Position position=new Position(csvTx.getTxHash(), csvTx.getTimeStamp(), new BigDecimal(subTx.getAmount()),mapperUtil.convert(holding, new Holding()));
                         positionRepository.save(position);
                     } else {// incoming değilse yani outgoing
                         List<PositionDTO> positionDTOList=holding.getPositions().
                                            stream().
                                            filter(positionDTO -> positionDTO.getAmount().compareTo(BigDecimal.ZERO)>0).
                                            sorted((e1, e2) -> e2.getTimeStamp().compareTo(e1.getTimeStamp())).collect(Collectors.toList());
                         BigDecimal remaining=new BigDecimal(subTx.getAmount());
                         for (PositionDTO positionDTO : positionDTOList) {
                           if(remaining.compareTo(BigDecimal.ZERO)>0) {
                               if (positionDTO.getAmount().compareTo(remaining) > 0) {
                                   positionDTO.setAmount(positionDTO.getAmount().subtract(remaining));
                                   Position position = mapperUtil.convert(positionDTO, new Position());
                                   positionRepository.save(position);
                               } else {
                                   remaining = remaining.subtract(positionDTO.getAmount());
                                   positionDTO.setAmount(BigDecimal.ZERO);
                                   Position position = mapperUtil.convert(positionDTO, new Position());
                                   positionRepository.save(position);
                               }
                           }else break;
                         }
                     }
                 }

            }

        }

        // start with Account if no then create an new with AccountNo
        // if there is an account do following
        // //start iterating sub transactions
        //for each subtansaction
        //  check current Account if it has this holding

    }

    public Holding createHolding(Currency currency, Account account){
        Holding holding = new Holding();
        holding.setCurrency(currency);
        holding.setAccountNo(account);
        Holding holding1= holdingRepository.save(holding);
        holdingRepository.flush();
        return holding1;
    }
}
