package com.service.mock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.service.mock"})
@EnableAsync(proxyTargetClass = true)
public class MockApplication {

	public static void main(String[] args) {
		SpringApplication.run(MockApplication.class, args);
	}

}
