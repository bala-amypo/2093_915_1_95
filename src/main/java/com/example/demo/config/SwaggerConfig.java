package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotationConfiguration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        Server amypoServer = new Server();
        amypoServer.setUrl("https://9315.408procr.amypo.ai/");
        amypoServer.setDescription("AmyPo Gateway Server");

        return new OpenAPI()
                .info(new Info()
                        .title("Asset Lifecycle Tracking API")
                        .version("1.0")
                        .description("API documentation for Asset Lifecycle Tracking System"))
                .servers(List.of(amypoServer));
    }
}
