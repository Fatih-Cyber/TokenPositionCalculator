package com.example.tokenpositioncalculator.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "accounts")
public class Account extends BaseEntity {
    String accountNo;
    @OneToMany(mappedBy="accountNo")
    private List<Holding> holdings;
    BigDecimal accountTotal;//@Transient??
}
