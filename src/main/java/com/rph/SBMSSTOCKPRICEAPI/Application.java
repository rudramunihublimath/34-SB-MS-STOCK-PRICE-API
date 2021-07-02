package com.rph.SBMSSTOCKPRICEAPI;

import com.rph.SBMSSTOCKPRICEAPI.entity.StockPrice;
import com.rph.SBMSSTOCKPRICEAPI.repo.StockPriceRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

@EnableDiscoveryClient
@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		StockPriceRepo repo = context.getBean(StockPriceRepo.class);
		StockPrice s= new StockPrice();
		s.setCompName("SBI");
		s.setCompPrice(300.00);
		StockPrice byCompName = repo.findByCompName(s.getCompName());
		if(!byCompName.getCompName().equals(s.getCompName()))
			repo.save(s);
	}

}
