package com.example.tokenpositioncalculator.controller;

import com.example.tokenpositioncalculator.dto.AccountDTO;
import com.example.tokenpositioncalculator.service.AccountService;
import com.example.tokenpositioncalculator.service.PositionBuiderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@AllArgsConstructor
@Controller
public class DashBoardController {
    private final AccountService accountService;
    private final PositionBuiderService positionBuiderService;


    @GetMapping("/analysis/dashboard")
    public String showDashboard(Model model) {
        positionBuiderService.buildPositionsFromCsv("/Users/ismailyildirim/Desktop/CsvFinal.csv");
        List<AccountDTO> accountDTOList = accountService.findAll();

        model.addAttribute("accounts", accountDTOList);
        return "/analysis/dashboard";
    }

}
