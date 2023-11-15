package com.example.DemoApiGateway.appConfig;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/api/v1/**")
                        .uri("lb://authentication-service2:8084/"))

                .route(p->p
                        .path("/api/v2/**")
                        .uri("lb://product-service2:8081/"))
                .build();
    }

}
