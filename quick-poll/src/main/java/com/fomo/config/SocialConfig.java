package com.fomo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.web.ConnectController;
import org.springframework.social.connect.web.ProviderSignInController;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.web.DisconnectController;

import com.fomo.security.social.SocialNetworkingSignInAdapter;
import com.fomo.security.social.SocialNetworkingSignUp;
import com.fomo.security.social.SocialNetworkingUsersDetailsService;

@Configuration
@EnableSocial
@PropertySource("classpath:/application.properties")
// @EnableAspectJAutoProxy(proxyTargetClass = false)
public class SocialConfig {

	@Autowired(required = true)
	public DataSource dataSource;

	@Autowired(required = true)
	Environment env;
	@Autowired
	ConnectionFactoryLocator connectionFactoryLocator;

	@Bean
	@Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
	public Facebook facebookTemplate(ConnectionRepository connectionRepository) {
		Connection<Facebook> facebookConnection = connectionRepository.findPrimaryConnection(Facebook.class);
 		return facebookConnection != null ? facebookConnection.getApi() : null;
	}

	/*
	 * @Bean public ConnectController connectController(ConnectionFactoryLocator
	 * connectionFactoryLocator, ConnectionRepository connectionRepository) {
	 * ConnectController connectController = new
	 * ConnectController(connectionFactoryLocator, connectionRepository);
	 * 
	 * return connectController; }
	 */

	@Bean
	public DataSourceInitializer databasePopulator() {
		ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
		populator.addScript(
				new ClassPathResource("org/springframework/social/connect/jdbc/JdbcUsersConnectionRepository.sql"));
		populator.setContinueOnError(true); // Continue in case the create
											// script already ran
		DataSourceInitializer initializer = new DataSourceInitializer();
		initializer.setDatabasePopulator(populator);
		initializer.setDataSource(dataSource);
		return initializer;
	}

	@Bean
	public UserIdSource userIdSource() {
		return new UserIdSource() {
			@Override
			public String getUserId() {
				Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
				if (authentication == null) {
					throw new IllegalStateException("Unable to get a ConnectionRepository: no user signed in");
				}
				System.err.println("Authentication " + authentication.getName());
				return authentication.getName();
			}
		};
	}

}
