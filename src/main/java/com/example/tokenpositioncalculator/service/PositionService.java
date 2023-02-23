package com.example.tokenpositioncalculator.service;


import com.example.tokenpositioncalculator.dto.HoldingDTO;
import com.example.tokenpositioncalculator.dto.PositionDTO;

import java.util.List;

public interface PositionService {
    List<PositionDTO> findAllPositionByHoldingId(Long positionId);
}
