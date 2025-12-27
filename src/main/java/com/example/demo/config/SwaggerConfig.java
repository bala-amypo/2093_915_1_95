package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        Server localServer = new Server();
        localServer.setUrl("http://localhost:8080");
        localServer.setDescription("Local Development Server");

        return new OpenAPI()
                .info(new Info()
                        .title("Personal Finance Budget Planner API")
                        .version("1.0")
                        .description("API documentation for Personal Finance Budget Planner System"))
                .servers(List.of(localServer));
    }
}