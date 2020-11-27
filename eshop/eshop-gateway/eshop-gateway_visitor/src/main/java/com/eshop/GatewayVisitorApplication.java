package com.eshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient

public class GatewayVisitorApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayVisitorApplication.class,args);
    }
}
