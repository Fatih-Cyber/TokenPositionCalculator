package com.example.tokenpositioncalculator.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Holding extends BaseEntity{
    @ManyToOne
    private Account accountNo;
    @ManyToOne
    private Currency currency;
    private BigDecimal totalValue;
    @OneToMany(mappedBy="holding")
    private List<Position> positions;

}
