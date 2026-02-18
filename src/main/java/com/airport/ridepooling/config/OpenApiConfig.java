package com.airport.ridepooling.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Smart Airport Ride Pooling API")
                        .version("1.0.0")
                        .description(
                                "A high-performance backend system for managing and grouping airport cab requests. " +
                                        "Supports dynamic pricing, optimistic locking for concurrency, and real-time pooling logic.")
                        .contact(new Contact()
                                .name("Airport Support")
                                .email("support@airport-pooling.com")));
    }
}
