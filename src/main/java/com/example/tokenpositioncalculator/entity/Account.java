package com.example.tokenpositioncalculator.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
