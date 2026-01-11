package com.database.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.database.service.Customauthservice;

@Configuration
@EnableWebSecurity
public class securityConfig {
	@Bean
	public SecurityFilterChain security(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth->auth
				.requestMatchers("/createmep").permitAll()
				.anyRequest().authenticated()
		).httpBasic(Customizer.withDefaults())
		.csrf(csrf->csrf.disable());
		return http.build();
	}
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService userdetailservice() {
		return new Customauthservice();
	}
	
	@SuppressWarnings("deprecation")
	@Bean 
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider daouth= new DaoAuthenticationProvider();
		daouth.setUserDetailsService(userdetailservice());
		daouth.setPasswordEncoder(new BCryptPasswordEncoder(12));
		return daouth;
	}

}
