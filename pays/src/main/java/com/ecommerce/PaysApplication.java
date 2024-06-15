package com.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PaysApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaysApplication.class, args);
	}

}
