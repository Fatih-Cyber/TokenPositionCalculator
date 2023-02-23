package com.example.tokenpositioncalculator.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PositionDTO {
    private Long id;
    private String timeStamp;
    private BigDecimal amount;
}
