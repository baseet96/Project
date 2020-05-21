package com.ecommerce.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// hardcodes in credentials with roles that pass authentication 
		auth.inMemoryAuthentication().withUser("admin").password("password").roles("ADMIN")
		.and().withUser("user").password("password").roles("USER");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().and().cors().and().authorizeRequests()
		.antMatchers("/index.html", "/", "/home", "/login", "/shopper/home", "/registration").permitAll()
		.antMatchers(HttpMethod.GET,  "/products/**").permitAll() // Specifies which GET api routes doesn't need authentication
		.antMatchers("/**").hasAnyRole("USER", "ADMIN") // Specifies which API route a user role can access
		//.antMatchers(HttpMethod.POST, "/auth/**").permitAll() // Specifies which POST api route doesn't need authentication
		.anyRequest().authenticated()
		.and().csrf().disable();
	}
	
// 	@Bean
// 	HeaderHttpSessionStrategy sessionStrategy() {
// 		return new HeaderHttpSessionStrategy();
// 	}
}
