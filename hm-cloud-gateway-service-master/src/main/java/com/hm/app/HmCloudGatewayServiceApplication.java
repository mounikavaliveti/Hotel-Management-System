package com.hm.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:3000")
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class HmCloudGatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HmCloudGatewayServiceApplication.class, args);
	}

}
