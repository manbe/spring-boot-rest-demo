package com.seleznov.demo.restapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Created by illcko
 */
@EnableSwagger2
@ComponentScan(basePackages = "seleznov.demo.restapp.rest.controller")
public class SwaggerConfig {

    @Bean
    public Docket swaggerSpringMvcPlugin() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo()).select().paths(regex("/api.*")).build();
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = ApiInfo.DEFAULT;
        return apiInfo;
    }

}
