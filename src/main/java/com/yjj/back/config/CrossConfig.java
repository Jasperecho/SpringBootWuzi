package com.yjj.back.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CrossConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**")
                    .allowedOrigins("**")
                    .allowedMethods("GET", "POST", "DELETE", "PUT")
                    .allowCredentials(true)
                    .allowedMethods("*")
                    .maxAge(3600)
                    .allowedHeaders("*");
    }
}
