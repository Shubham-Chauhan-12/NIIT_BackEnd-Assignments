package com.niit.apiGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
	@Bean
	public RouteLocator getRoutes(RouteLocatorBuilder builder)
	{
		return builder.routes().route(p->p.path("/track/v1/**").uri("http://music-service:8086/"))
				.route(p->p.path("/**").uri("http://authentication-service:8085/")).build();
	}

}
