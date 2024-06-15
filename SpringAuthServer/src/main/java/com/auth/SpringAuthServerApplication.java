package com.auth;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableEurekaClient
@SpringBootApplication
public class SpringAuthServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAuthServerApplication.class, args);
	}

	@GetMapping("/user")
	public Principal getUser(Principal user) {
		return user;
	}
}
