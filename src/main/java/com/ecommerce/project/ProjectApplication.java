package com.ecommerce.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
@EnableJpaRepositories("com.*")
@EntityScan("com.*")
@ComponentScan("com.*")
public class ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

	@Configuration
	public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

		@Autowired
		public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
			auth.inMemoryAuthentication()
				.withUser("user").password("password").roles("USER")
			.and()
				.withUser("admin").password("admin").roles("USER", "ADMIN", "READER", "WRITER");
		}
		
		@Override
	    protected void configure(HttpSecurity http) throws Exception {
	    	http
	    		.httpBasic()
	    	.and()
	        	.authorizeRequests()
	        	.antMatchers("/index.html", "/", "/home", "/login").permitAll()
	        	.anyRequest().authenticated();
	    }
	}
}