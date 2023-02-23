package com.example.tokenpositioncalculator.service;
import com.example.tokenpositioncalculator.model.CsvTx;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class PositionBuilderOld {
    public static HashMap<String,LinkedList<Position>> buildPositionsFromCsv(String fileName){
          List<CsvTx> trx=CsvReader.readTransactionsCsv(fileName);
        HashMap<String,LinkedList<Position>> result=new HashMap<>();

        for (CsvTx csvTx : trx) {
            if (result.containsKey(csvTx.getAccount())) {
             LinkedList<Position> ll=result.get(csvTx.getAccount());
             Position p=new Position(csvTx.getTxHash(), csvTx.getTimeStamp(), csvTx.getAccount(), "", csvTx.getSubTransactionList());
             ll.addLast(p);
             result.put(csvTx.getAccount(),ll);
            }else{
                LinkedList<Position> ll=new LinkedList<>();
                Position p=new Position(csvTx.getTxHash(), csvTx.getTimeStamp(), csvTx.getAccount(), "", csvTx.getSubTransactionList());
                ll.addLast(p);
                result.put(csvTx.getAccount(),ll);
            }
        }
          return result;
    }
 }
