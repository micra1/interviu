package com.test.service.log;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
public class ServiceLogApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceLogApplication.class, args);
	}

}
