package com.example.tokenpositioncalculator.service;


import com.example.tokenpositioncalculator.dto.AccountDTO;
import com.example.tokenpositioncalculator.entity.Account;

public interface AccountService {
    void save(Account account);
    AccountDTO findByAccountNo(String accountNo);
}
