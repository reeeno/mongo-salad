package com.knowhere.mongosalad.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan("com.knowhere.mongosalad")
public class SaladConfiguration {
    private static final Logger logger = LogManager.getLogger(SaladConfiguration.class);

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
