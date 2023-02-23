package com.example.tokenpositioncalculator.controller;

import com.example.tokenanalysis.service.CsvService;
import com.example.tokenanalysis.service.GetTransactionsFromCsv;
import com.example.tokenpositioncalculator.service.AccountService;
import com.example.tokenpositioncalculator.service.PositionBuiderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@AllArgsConstructor
@Controller
public class DashBoardController {
    private final AccountService accountService;
    private final PositionBuiderService positionBuiderService;


    @GetMapping("/analysis/dashboard")
public String showDashboard(Model model){
        positionBuiderService.buildPositionsFromCsv("/Users/iceman/Desktop/CSVs/CsvFinal.csv").
       model.addAttribute("transactions", );
    return "/analysis/dashboard";
}

}
