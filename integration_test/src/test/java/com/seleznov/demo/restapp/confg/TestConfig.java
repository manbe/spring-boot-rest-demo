package com.seleznov.demo.restapp.confg;

import com.seleznov.demo.restapp.publisher.RestPublisherImpl;
import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import com.seleznov.demo.restapp.publisher.RestPublisher;

import javax.sql.DataSource;

/**
 * Created by illcko on 13.09.15.
 */
@Configuration
@ComponentScan("com.seleznov.demo.restapp")
public class TestConfig {

    public static final String SERVER_URL = "http://localhost:8080";

    @Autowired
    private DataSource dataSource;

    @Bean
    @Scope("prototype")
    public RestPublisher gerRestPublisher(){
        return new RestPublisherImpl(SERVER_URL, "user", "qwerty");
    }

    @Bean
    public SpringLiquibase liquibase() {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDropFirst(true);
        liquibase.setShouldRun(true);
        liquibase.setChangeLog("classpath:changeset-test-data.xml");
        liquibase.setDataSource(dataSource);
//        liquibase.setChangeLog("lol.xml");
        return liquibase;
    }
}
