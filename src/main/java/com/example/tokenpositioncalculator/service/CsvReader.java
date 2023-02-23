package com.example.tokenpositioncalculator.service;


import com.example.tokenpositioncalculator.model.CsvTx;
import com.example.tokenpositioncalculator.model.SubTx;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {
        private static final String COMMA_DELIMITER = ",";
        private static final String NEW_LINE_SEPARATOR = "\n";
        public static List<CsvTx> readTransactionsCsv(String filename){
            List<CsvTx> transactions = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(COMMA_DELIMITER);
                    CsvTx tx=new CsvTx();
                    tx.setTxHash(values[0]);
                    tx.setTimeStamp(values[1]);
                    tx.setAccount(values[2]);
                    tx.setSubTransactionList(new ArrayList<>(subTxIntoTxList(values[3])));
                    transactions.add(tx);
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            //return transactions.stream().filter(transaction -> transaction.getMethod().equals("Multicall")).limit(5).collect(Collectors.toList());
            return transactions;
        }
        public static ArrayList<SubTx> subTxIntoTxList(String str){
       str= str.substring(str.indexOf("[") + 1, str.indexOf("]"));
            String[] splited=str.split("\\{");
            ArrayList<SubTx> txDetailsArrayList=new ArrayList<>();
            ArrayList<String[]> subTransactions=new ArrayList<>();
            for (int i = 1; i < splited.length; i++) {
                String[] txSplited= splited[i].split("\\+");
                subTransactions.add(txSplited);
            }
            List<SubTx> subTxList=new ArrayList<>();
            for (String[] subTransaction : subTransactions) {
                ArrayList<String> res=new ArrayList<>();
                for (int i = 0; i < 4; i++) {
                    String[] typeSplit=subTransaction[i].split("\\:");
                    String s=typeSplit[1].replaceAll("[^a-zA-Z0-9]", "");
                    res.add(s);
                }
                SubTx aa=new SubTx(res.get(0), res.get(1), res.get(2), res.get(3));
                subTxList.add(aa);
            }
            return (ArrayList<SubTx>) subTxList;
        }
}
