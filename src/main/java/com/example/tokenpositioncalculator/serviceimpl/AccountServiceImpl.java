package com.example.tokenpositioncalculator.serviceimpl;

import com.example.tokenpositioncalculator.dto.AccountDTO;
import com.example.tokenpositioncalculator.entity.Account;
import com.example.tokenpositioncalculator.mapper.MapperUtil;
import com.example.tokenpositioncalculator.repository.AccountRepository;
import com.example.tokenpositioncalculator.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final MapperUtil mapperUtil;

    public AccountServiceImpl(AccountRepository accountRepository, MapperUtil mapperUtil) {
        this.accountRepository = accountRepository;
        this.mapperUtil = mapperUtil;
    }


    @Override
    public void save(Account account) {
        accountRepository.save(account);
    }

    @Override
    public AccountDTO findByAccountNo(String accountNo) {
         Account account=accountRepository.findAccountByAccountNo(accountNo).orElse(new Account());
         return mapperUtil.convert(account, new AccountDTO());
    }

    @Override
    public List<AccountDTO> findAll() {
        List<AccountDTO> accountDTOS
                = accountRepository.findAll().stream().map(account -> mapperUtil.convert(account, new AccountDTO())).collect(Collectors.toList());
        return accountDTOS;
    }
}
