package com.mywebapp.webProject.security;


//we have to import it default  \|/
import static org.springframework.security.config.Customizer.withDefaults;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
	
	




	@Bean
	public InMemoryUserDetailsManager createDetails() {
		Function<String, String> passwordEncoder
		=input->passwordEncoder().encode(input);
		
		UserDetails userDetails  =  User.builder()
										.passwordEncoder(passwordEncoder)
										.username("pinkucoder")
										.password("nitin")
										.roles("USER","ADMIN")
										.build();
		
		return new InMemoryUserDetailsManager (userDetails);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	
	
	// for access of h2 database 1.csrf disable 2.frames
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
				auth->auth.anyRequest().authenticated()
				);
		
		http.formLogin(withDefaults());
		http.csrf().disable();
		http.headers().frameOptions().disable();
		return http.build();
	}
}
