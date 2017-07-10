package com.hubezoo.hubezooproject.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class StaticResources extends WebMvcConfigurerAdapter  {

    private static String staticResourcesPath="/assets/";
 
 
 
 public static void main(String[] args) {
        SpringApplication.run(StaticResources.class, args);
    }
    
 @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**").addResourceLocations(staticResourcesPath);
        
    }    
}
