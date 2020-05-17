package com.lake.smartway.profile;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("prod")
@Configuration
public class BaseConfigration {

    @Bean
    public String hello(){
        return "hello prod";
    }
}
