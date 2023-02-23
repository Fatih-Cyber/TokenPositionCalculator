package com.example.tokenpositioncalculator.entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
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
