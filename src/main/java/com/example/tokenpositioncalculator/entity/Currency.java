package com.example.tokenpositioncalculator.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "currencies")
public class Currency extends BaseEntity{

    @Column(unique = true)
    private String code;
    @Column(unique = true)
    private String name;
    private boolean isBaseCurrency;

}
