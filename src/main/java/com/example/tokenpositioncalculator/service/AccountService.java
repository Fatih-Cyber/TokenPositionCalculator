package com.example.tokenpositioncalculator.service;


import com.example.tokenpositioncalculator.dto.AccountDTO;
import com.example.tokenpositioncalculator.entity.Account;

import java.util.List;

public interface AccountService {
    void save(Account account);
    AccountDTO findByAccountNo(String accountNo);

    List<AccountDTO> findAll();
}
