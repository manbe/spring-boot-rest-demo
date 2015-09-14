package seleznov.demo.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import seleznov.demo.rest.config.SwaggerConfig;

@SpringBootApplication
@Import(SwaggerConfig.class)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
