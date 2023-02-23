package com.example.tokenpositioncalculator.controller;

import com.example.tokenpositioncalculator.dto.HoldingDTO;
import com.example.tokenpositioncalculator.dto.PositionDTO;
import com.example.tokenpositioncalculator.service.HoldingService;
import com.example.tokenpositioncalculator.service.PositionBuiderService;
import com.example.tokenpositioncalculator.service.PositionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@AllArgsConstructor
@Controller
public class PositionController {
    private final PositionService positionService;


    @GetMapping("/analysis/position/{positionId}")
    public String showDashboard(@PathVariable("positionId") Long holdingId, Model model) {
        List<PositionDTO> positionDTOS = positionService.findAllPositionByHoldingId(holdingId);


        model.addAttribute("positions", positionDTOS);
        return "/analysis/positions";
    }

}
