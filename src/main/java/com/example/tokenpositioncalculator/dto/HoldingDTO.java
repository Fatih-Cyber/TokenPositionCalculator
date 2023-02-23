package com.example.tokenpositioncalculator.dto;

import com.example.tokenpositioncalculator.entity.Account;
import com.example.tokenpositioncalculator.entity.Currency;
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
public class HoldingDTO {
    private Long id;
    private Account accountNo;
    private Currency currency;
    private BigDecimal totalValue;
    private List<PositionDTO> positions;
}
