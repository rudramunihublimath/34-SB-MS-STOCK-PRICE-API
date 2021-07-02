package com.rph.SBMSSTOCKPRICEAPI.repo;


import com.rph.SBMSSTOCKPRICEAPI.entity.StockPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface StockPriceRepo extends JpaRepository<StockPrice, Serializable> {

    StockPrice findByCompName(String compName);
}
