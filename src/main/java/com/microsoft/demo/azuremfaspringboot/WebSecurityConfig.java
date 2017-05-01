package com.microsoft.demo.azuremfaspringboot;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// TODO: findout how to enable CSRF
		http.authorizeRequests().antMatchers("/").permitAll()
				// .and().csrf()
				// .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
				.and().csrf().disable();
		// .anyRequest().authenticated()
		// .filterSecurityInterceptorOncePerRequest(true)
		// .and().addFilterAt(new AdalFilter(),BasicAuthenticationFilter.class);
	}

}
