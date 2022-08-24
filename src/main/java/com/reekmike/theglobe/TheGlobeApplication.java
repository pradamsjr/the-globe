package com.reekmike.theglobe;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.web.client.RestTemplate;

import java.util.Properties;

@SpringBootApplication
public class TheGlobeApplication {
    private static final Logger logger = LogManager.getLogger(TheGlobeApplication.class);

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return new RestTemplate();
    }

    @Bean
    public Properties applicationProperties(){
        Resource resource = new ClassPathResource("/application.properties");
        Properties applicationProperties = new Properties();

        try {
            applicationProperties = PropertiesLoaderUtils.loadProperties(resource);
        } catch (Exception ex){
            ex.printStackTrace();
        } finally {
            if (applicationProperties == null){
                applicationProperties = new Properties();
            }
        }

        return applicationProperties;
    }

    public static void main(String[] args) {
        SpringApplication.run(TheGlobeApplication.class, args);
    }
}
