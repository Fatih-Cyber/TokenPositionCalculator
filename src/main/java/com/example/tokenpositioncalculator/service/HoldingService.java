package com.example.tokenpositioncalculator.service;


import com.example.tokenpositioncalculator.dto.AccountDTO;
import com.example.tokenpositioncalculator.dto.HoldingDTO;
import com.example.tokenpositioncalculator.entity.Account;

import java.util.List;

public interface HoldingService {
    List<HoldingDTO> findAllHoldings(String accountNo);
}
