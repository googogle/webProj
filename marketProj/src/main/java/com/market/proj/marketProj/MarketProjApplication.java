package com.market.proj.marketProj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MarketProjApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(MarketProjApplication.class, args);
	}

}
