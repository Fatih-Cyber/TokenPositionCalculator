package com.example.tokenpositioncalculator.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class Position extends BaseEntity{
    private String txHash;
    private String timeStamp;
    private BigDecimal amount;
    @ManyToOne
    private Holding holding;

}
