package com.microservice.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.microservice.client.controller.exception.CustomErrorDecoder;

@Configuration
public class FeignExceptionConfiguration {

    @Bean
    public CustomErrorDecoder customErrorDecoder() {
        return new CustomErrorDecoder();
    }

}
