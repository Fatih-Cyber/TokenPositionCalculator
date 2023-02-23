package com.example.tokenpositioncalculator.serviceimpl;

import com.example.tokenpositioncalculator.dto.AccountDTO;
import com.example.tokenpositioncalculator.entity.Account;
import com.example.tokenpositioncalculator.mapper.AccountMapper;
import com.example.tokenpositioncalculator.mapper.MapperUtil;
import com.example.tokenpositioncalculator.repository.AccountRepository;
import com.example.tokenpositioncalculator.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final MapperUtil mapperUtil;


    @Override
    public void save(Account account) {
        accountRepository.save(account);
    }

    @Override
    public AccountDTO findByAccountNo(String accountNo) {
         Account account=accountRepository.findAccountByAccountNo(accountNo).orElse(new Account());
         return mapperUtil.convert(account, new AccountDTO());
    }
}
