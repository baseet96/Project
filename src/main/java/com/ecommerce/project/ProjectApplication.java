package com.ecommerce.project;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@SpringBootApplication
@EnableJpaRepositories("com.*")
@EntityScan("com.*")
@ComponentScan("com.*")
public class ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

	@EnableWebSecurity
	public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

		@Autowired
		public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
			auth.inMemoryAuthentication()
				.withUser("customer@infosys.com").password("password").roles("USER")
			.and()
				.withUser("admin").password("admin").roles("USER", "ADMIN", "READER", "WRITER");
		}
		
		@Override
	    protected void configure(HttpSecurity http) throws Exception {
//	    	http
//	    		.httpBasic()
////	    	.and()
////	    		.cors()
//	    	.and()
//	        	.authorizeRequests()
//	        		.antMatchers(
//        				"/index.html", 
//        				"/", 
//        				"/home",
//        				"/login", 
//        				"/shopper/home", 
//        				"/registration"
//	        		).permitAll()
//	        		.antMatchers(HttpMethod.GET, "/auth/**", "/products/all/").permitAll()
//	                .antMatchers(HttpMethod.POST, "/auth/**").permitAll()
//	        		.anyRequest().authenticated()
//	        .and()
//	        	.csrf().disable();
	       
	    	
			http
				.cors()
			.and()
				.authorizeRequests()
		    		.anyRequest().authenticated()
			 .and()
	        	.csrf().disable();
	    }
		
		
//		@Bean
//		HeaderHttpSessionStrategy sessionStrategy() {
//			return new HeaderHttpSessionStrategy();
//		}
	}
}