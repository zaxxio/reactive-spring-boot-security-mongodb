package org.wsd.app.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
@RequiredArgsConstructor
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().info(new Info().title("Spring Boot App")
                .description("Fully Reactive Spring Boot")
                .version("0.0.1"));
    }

}
