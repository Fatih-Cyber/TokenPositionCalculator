package com.example.tokenpositioncalculator.serviceimpl;


import com.example.tokenpositioncalculator.dto.HoldingDTO;
import com.example.tokenpositioncalculator.dto.PositionDTO;
import com.example.tokenpositioncalculator.mapper.MapperUtil;
import com.example.tokenpositioncalculator.repository.HoldingRepository;
import com.example.tokenpositioncalculator.repository.PositionRepository;
import com.example.tokenpositioncalculator.service.HoldingService;
import com.example.tokenpositioncalculator.service.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PositionServiceImpl implements PositionService {
    private final PositionRepository positionRepository;
    private final MapperUtil mapperUtil;

    @Override
    public List<PositionDTO> findAllPositionByHoldingId(Long holdingId) {
        List<PositionDTO> positionDTOList = positionRepository.findAllByHoldingId(holdingId).stream().map(position -> mapperUtil.convert(position, new PositionDTO())).collect(Collectors.toList());

        for (PositionDTO position:
             positionDTOList) {
            LocalDateTime localDateTime = LocalDateTime.parse(position.getTimeStamp());
            position.setTimeStamp(String.valueOf(ChronoUnit.DAYS.between(LocalDateTime.now(),localDateTime)));
        }
        return positionDTOList;
    }
}
