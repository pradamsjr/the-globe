package com.reekmike.theglobe;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class TheGlobeApplication {
    private static final Logger logger = LogManager.getLogger(TheGlobeApplication.class);

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(TheGlobeApplication.class, args);
    }
}
