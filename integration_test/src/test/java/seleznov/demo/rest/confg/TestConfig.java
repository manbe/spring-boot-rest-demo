package seleznov.demo.rest.confg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import seleznov.demo.rest.publisher.RestPublisher;
import seleznov.demo.rest.publisher.RestPublisherImpl;

/**
 * Created by illcko on 13.09.15.
 */
@Configuration
@ComponentScan("seleznov.demo.rest")
public class TestConfig {

    public static final String SERVER_URL = "http://localhost:8080";

    @Bean
    public RestPublisher gerRestPublisher(){
        return new RestPublisherImpl(SERVER_URL, "user", "qwerty");
    }
}
