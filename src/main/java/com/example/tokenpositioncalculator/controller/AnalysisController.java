package com.example.tokenpositioncalculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/analysis")
public class AnalysisController {
    @GetMapping("/dashboard2")
    public String showDashboard(Model model){
        //model.addAttribute("transactions", GetTransactionsFromCsv.readTransactionsCsv("/Users/iceman/Downloads/TokenAnalysis-master/token.csv"));
        return "/analysis/dashboard2";
    }
}
