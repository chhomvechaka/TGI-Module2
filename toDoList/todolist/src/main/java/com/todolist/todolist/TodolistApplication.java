package com.todolist.todolist;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class TodolistApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodolistApplication.class, args);
	}
  @Bean
  FilterRegistrationBean crossfilter(){
    UrlBasedCorsConfigurationSource url=new UrlBasedCorsConfigurationSource();
    CorsConfiguration config=new CorsConfiguration();
    config.setAllowedMethods(Arrays.asList("POST","GET","PATCH","DELETE","OPTIONS","UPDATE"));
    config.setAllowedOrigins(Arrays.asList("http://localhost:4200","http://localhost:8080","http://localhost:9099"));
    config.setAllowedHeaders(Arrays.asList("authorization", "content-type", "x-auth-token"));
    config.setExposedHeaders(Collections.singletonList("x-auth-token"));
        FilterRegistrationBean<?> bean = new FilterRegistrationBean(new CorsFilter(url));
        url.registerCorsConfiguration("/**", config);
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
  }
}
