package com.example.tokenpositioncalculator.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@AllArgsConstructor
@Setter@Getter
@NoArgsConstructor
public class CsvTx {
    String txHash;
    String timeStamp;
    String Account;
    ArrayList<SubTx> subTransactionList;

}
