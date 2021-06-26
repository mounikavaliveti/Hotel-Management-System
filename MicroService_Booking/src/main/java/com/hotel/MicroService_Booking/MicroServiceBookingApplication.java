package com.hotel.MicroService_Booking;

import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@SpringBootApplication
@EnableEurekaClient
public class MicroServiceBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceBookingApplication.class, args);
	}
	
	}

