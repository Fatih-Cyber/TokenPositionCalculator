package com.example.tokenpositioncalculator.controller;

import com.example.tokenpositioncalculator.dto.AccountDTO;
import com.example.tokenpositioncalculator.dto.HoldingDTO;
import com.example.tokenpositioncalculator.service.AccountService;
import com.example.tokenpositioncalculator.service.HoldingService;
import com.example.tokenpositioncalculator.service.PositionBuiderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@AllArgsConstructor
@Controller
public class HoldingController {
    private final HoldingService holdingService;
    private final PositionBuiderService positionBuiderService;


    @GetMapping("/analysis/holding/{accountNo}")
    public String showDashboard(@PathVariable("accountNo") String accountNo, Model model) {
        List<HoldingDTO> holdingDTOS = holdingService.findAllHoldings(accountNo);


        model.addAttribute("holdings", holdingDTOS);
        return "/analysis/holdings";
    }

}
