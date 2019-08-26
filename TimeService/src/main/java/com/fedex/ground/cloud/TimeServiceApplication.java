package com.fedex.ground.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TimeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimeServiceApplication.class, args);
	}

}
