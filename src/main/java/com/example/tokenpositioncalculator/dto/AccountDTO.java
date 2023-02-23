package com.example.tokenpositioncalculator.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {
    private Long id;
    private String accountNo;
    private List<HoldingDTO> holdings;
    private BigDecimal accountTotal;
    public AccountDTO(List<HoldingDTO> holdings) {
        this.holdings = holdings;
    }

}
