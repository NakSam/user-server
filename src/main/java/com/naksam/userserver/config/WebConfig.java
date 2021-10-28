package com.naksam.userserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/cookie")
                .allowedOrigins("*")
                .allowedMethods("POST", "OPTIONS","GET", "PUT", "DELETE")
                .allowCredentials(true).maxAge(500);
    }
}