package com.example.tokenpositioncalculator.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "currencies")
public class Currency extends BaseEntity{

    @Column(unique = true)
    String code;
    @Column(unique = true)
    String name;
    private boolean isBaseCurrency;

}
