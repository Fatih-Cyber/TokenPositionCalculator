package com.example.tokenpositioncalculator.repository;

import com.example.tokenpositioncalculator.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position,Long> {
}
