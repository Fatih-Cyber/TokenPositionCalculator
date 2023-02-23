package com.example.tokenpositioncalculator.repository;

import com.example.tokenpositioncalculator.entity.Currency;
import com.example.tokenpositioncalculator.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CurrencyRepository extends JpaRepository<Currency,Long> {
    Currency findByCode(String code);
}
