package com.fomo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.mem.InMemoryUsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInController;
import org.springframework.social.facebook.web.DisconnectController;
import org.springframework.social.security.SpringSocialConfigurer;
import org.springframework.web.filter.HiddenHttpMethodFilter;

import com.fomo.security.social.SocialNetworkingSignInAdapter;
import com.fomo.security.social.SocialNetworkingSignUp;
import com.fomo.security.social.SocialNetworkingUsersDetailsService;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = { "com.fomo.security.social" })
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource dataSource;

	@Autowired
	UserDetailsService userDetailsService;

	@Autowired
	SocialNetworkingSignInAdapter signInAdapter;

	@Bean
	UserDetailsService x() {
		return userDetailsService();
	}

	@Bean
	SocialNetworkingUsersDetailsService getSocialNetworkingUserDeta() {
		SocialNetworkingUsersDetailsService c = new SocialNetworkingUsersDetailsService();
		c.setUserDetailsService(x());
		return c;
	}

	@Autowired(required = true)
	SocialNetworkingSignUp signUp;
	
	@Autowired
	ConnectionFactoryLocator connectionFactoryLocator;

	@Bean
	@Primary
	@Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
	public UsersConnectionRepository getUsersConnectionRepository() {
		JdbcUsersConnectionRepository j = new JdbcUsersConnectionRepository(dataSource, connectionFactoryLocator,
				Encryptors.noOpText());
		j.setConnectionSignUp(signUp);
		return j;
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
		web.ignoring().antMatchers("/css/**","/images/**", "/js/**","/img/**", "/fonts/**");
		 
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
//		http.authorizeRequests().antMatchers("/css/**", "/fonts/**","/img/**", "/images/**", "/js/**","/images/**").permitAll();
 		http.formLogin().loginPage("/signin").loginProcessingUrl("/signin/authenticate")
				.failureUrl("/signin?param.error=bad_credentials").and().logout().logoutUrl("/signout")
				.deleteCookies("JSESSIONID").and().authorizeRequests()
				.antMatchers("/admin/**", "/favicon.ico", "/resources/**", "/auth/**", "/signin/**", "/signup/**",
						"/disconnect/facebook","/polls/**","/api/api-docs/**", "/api-docs/**", "/rest/v1/**")
				.permitAll().antMatchers("/**").authenticated().and().rememberMe().and()
				.apply(new SpringSocialConfigurer());
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//JdbcUserDetailsManager j = new JdbcUserDetailsManager();
		auth.jdbcAuthentication().dataSource(dataSource);
	}

	@Bean
	ProviderSignInController providerSignController() {
		return new ProviderSignInController(connectionFactoryLocator, getUsersConnectionRepository(), signInAdapter);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
}
