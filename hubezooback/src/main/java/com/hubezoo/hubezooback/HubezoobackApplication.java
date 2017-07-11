package com.hubezoo.hubezooback;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;

@SpringBootApplication
@Configuration
@ComponentScan("com.hubezoo.hubezooback")
@EnableAutoConfiguration
public class HubezoobackApplication {
	 
	 @Bean  
	 public SessionFactory sessionFactory(HibernateEntityManagerFactory hemf){  
	     return hemf.getSessionFactory();  
	 } 

	public static void main(String[] args) {
		SpringApplication.run(HubezoobackApplication.class, args);
	}
}
