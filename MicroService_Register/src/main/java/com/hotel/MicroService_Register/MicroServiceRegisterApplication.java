package com.hotel.MicroService_Register;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroServiceRegisterApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceRegisterApplication.class, args);
	}

}
