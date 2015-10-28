package seleznov.demo.restapp.confg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import seleznov.demo.restapp.publisher.RestPublisher;
import seleznov.demo.restapp.publisher.RestPublisherImpl;

/**
 * Created by illcko on 13.09.15.
 */
@Configuration
@ComponentScan("seleznov.demo.restapp")
public class TestConfig {

    public static final String SERVER_URL = "http://localhost:8080";

    @Bean
    @Scope("prototype")
    public RestPublisher gerRestPublisher(){
        return new RestPublisherImpl(SERVER_URL, "user", "qwerty");
    }
}
