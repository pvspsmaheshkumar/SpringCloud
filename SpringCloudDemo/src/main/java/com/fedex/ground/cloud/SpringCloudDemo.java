package com.fedex.ground.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@EnableAutoConfiguration
@EnableEurekaClient
public class SpringCloudDemo {
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudDemo.class, args);
	}
	
	@RequestMapping("/")
    public String home() {
        return "Hello world";
    }
}
