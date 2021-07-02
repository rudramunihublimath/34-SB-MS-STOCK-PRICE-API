package com.rph.SBMSSTOCKPRICEAPI.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer stockId;
    private String compName;
    private Double compPrice;
}
