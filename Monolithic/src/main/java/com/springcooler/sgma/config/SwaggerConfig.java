package com.springcooler.sgma.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

/* 설명. Swagger는  OpenAPI Specification(OAS)이다. */
/* 설명. http://localhost:8080/swagger-ui/index.html */
@OpenAPIDefinition(
        info = @Info(title = "SGMA API 명세서",
                description = "SGMA API 명세서"))
@Configuration
public class SwaggerConfig {

}