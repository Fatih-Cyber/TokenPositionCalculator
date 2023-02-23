package com.example.tokenpositioncalculator.repository;

import com.example.tokenpositioncalculator.entity.Account;
import com.example.tokenpositioncalculator.entity.Holding;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HoldingRepository extends JpaRepository<Holding, Long> {
    List<Holding> findAccountByAccountNo(String accountNumber);
    List<Holding> findAll();
}
