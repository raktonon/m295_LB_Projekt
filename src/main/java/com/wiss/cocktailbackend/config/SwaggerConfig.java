package com.wiss.cocktailbackend.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI().info(new Info()
            .title("Cocktail API")
            .description("LB295 Cocktail Backend")
            .version("v1"));
    }
}
