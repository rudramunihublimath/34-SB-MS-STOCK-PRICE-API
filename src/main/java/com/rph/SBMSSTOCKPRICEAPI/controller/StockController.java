package com.rph.SBMSSTOCKPRICEAPI.controller;


import com.rph.SBMSSTOCKPRICEAPI.entity.StockPrice;
import com.rph.SBMSSTOCKPRICEAPI.entity.StockPriceResp;
import com.rph.SBMSSTOCKPRICEAPI.repo.StockPriceRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StockController {
    @Autowired
    private StockPriceRepo repo;
    @Autowired
    private Environment environment;

    @GetMapping("/price")
    public ResponseEntity<StockPriceResp>  getStockPrice(@RequestParam String compName){
        StockPrice stockPrice = repo.findByCompName(compName);
        String port = environment.getProperty("local.server.port");
        StockPriceResp res= new StockPriceResp();
        BeanUtils.copyProperties(stockPrice,res);
        res.setPort(Integer.parseInt(port));
        return new ResponseEntity<StockPriceResp>(res,HttpStatus.OK);
    }

    @GetMapping
    public String msg(){
        return "Hello";
    }
}
