package com.example.tokenpositioncalculator.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubTx {
    private String type;
    private String symbol;
    private String amount;
    private String address;
}
