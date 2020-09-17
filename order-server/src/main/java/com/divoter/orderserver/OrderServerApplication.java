package com.divoter.orderserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.divoter"})
public class OrderServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServerApplication.class, args);
	}
}
