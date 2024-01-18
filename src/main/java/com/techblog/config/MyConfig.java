package com.techblog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class MyConfig {

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService userDetailsService() {

//		UserDetails admin = User.withUsername("dikshant").password(bCryptPasswordEncoder().encode("dikshant"))
//				.roles("ADMIN").build();
//
//		UserDetails user = User.withUsername("dikshu").password(bCryptPasswordEncoder().encode("dikshu")).roles("USER")
//				.build();
//
//		return new InMemoryUserDetailsManager(admin, user);
		
		CustomUserDetailsService customUserDetailsService = new CustomUserDetailsService();
		
		return customUserDetailsService;
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests((authoriz) -> authoriz.requestMatchers("api/user/").permitAll()
				.requestMatchers("apis/catagory/**").hasAnyRole("ADMIN", "USER").requestMatchers("apis/post/**")
				.hasAnyRole("ADMIN", "USER").anyRequest().permitAll()).httpBasic(Customizer.withDefaults());

		return http.build();
	}

}
