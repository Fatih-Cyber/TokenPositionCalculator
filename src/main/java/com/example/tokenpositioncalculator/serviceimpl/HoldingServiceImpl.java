package com.example.tokenpositioncalculator.serviceimpl;


import com.example.tokenpositioncalculator.dto.AccountDTO;
import com.example.tokenpositioncalculator.dto.HoldingDTO;
import com.example.tokenpositioncalculator.mapper.MapperUtil;
import com.example.tokenpositioncalculator.repository.HoldingRepository;
import com.example.tokenpositioncalculator.service.HoldingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class HoldingServiceImpl implements HoldingService {
    private final HoldingRepository holdingRepository;
    private final MapperUtil mapperUtil;
    public List<HoldingDTO> findAllHoldings(String accountNo){
        return holdingRepository.findAccountByAccountNo(accountNo).stream().map(holding -> mapperUtil.convert(holding, new HoldingDTO())).collect(Collectors.toList());
    }
}
