package com.rph.SBMSSTOCKPRICEAPI.entity;

import lombok.Data;

@Data
public class StockPriceResp {
    private Integer stockId;
    private String compName;
    private Double compPrice;
    private Integer port;

}
