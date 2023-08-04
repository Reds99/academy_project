package com.academy.project.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.academy.project.repository.AmministratoreRepository;


@Configuration
public class SecurityConfig {
	private AmministratoreRepository amministratoreRepository;

	public SecurityConfig(AmministratoreRepository amministratoreRepository) {
		this.amministratoreRepository = amministratoreRepository;
	}
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests()
		.antMatchers("/")
		.permitAll()
		.antMatchers("/admin/**")
		.hasRole("ADMIN")
		.and()
		.formLogin()
		.loginPage("/loginAdmin")
		.permitAll()
		.and()
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logoutAdmin"))
		.logoutSuccessUrl("/admin/");
		
		return http.build();
	}
	
	@Bean
	DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(new AmministratoreDetailsService(amministratoreRepository));
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}
	
	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	

	

}
