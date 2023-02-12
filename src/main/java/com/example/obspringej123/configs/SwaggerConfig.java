package com.example.obspringej123.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

/**
 * Configuración Swagger para la generación de la API REST.
 *
 * HTML: http://localhost:8081/swagger-ui/
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiDetails())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiDetails() {
        return new ApiInfo(
                "Spring Boot Laptop API REST",
                "Laptops API REST docs",
                "1.0",
                "https://www.bing.com",
                new Contact("Alberto", "https://www.bing.com", "alberto@example.com"),
                "MIT",
                "https://www.bing.com",
                Collections.emptyList()
        );
    }
}
