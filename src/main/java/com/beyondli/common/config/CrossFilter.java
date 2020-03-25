package com.beyondli.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author beyondLi
 * @desc 解决跨域问题
 */
@Configuration
public class CrossFilter extends WebMvcConfigurerAdapter {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        String[] origins = {"*"};
        registry.addMapping("/**")
                .allowedOrigins(origins)
                .allowCredentials(true)
                .allowedMethods("*")
                .maxAge(3600);
    }

}
