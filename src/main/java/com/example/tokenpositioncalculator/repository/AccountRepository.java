package com.example.tokenpositioncalculator.repository;

import com.example.tokenpositioncalculator.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional <Account> findAccountByAccountNo(String accountNumber);
    List<Account> findAll();
}
