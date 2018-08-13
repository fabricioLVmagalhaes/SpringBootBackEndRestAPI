package com.fabriciomagalhaes.cursomc.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private Environment env;

	// endpoints liberados sem atutenticação no spring security
	private static final String[] PUBLIC_MATCHERS = { "/h2-console/**"};	
	private static final String[] PUBLIC_MATCHERS_GET = { "/produtos/**", "/categorias/**", "/clientes/**" };

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		if (Arrays.asList(env.getActiveProfiles()).contains("test")) {
			http.headers().frameOptions().disable();//liberando acesso ao H2 DB para o profile de teste.
		}
		
		http.cors().and().csrf().disable();
		http.authorizeRequests()
		    .antMatchers(HttpMethod.GET, PUBLIC_MATCHERS_GET).permitAll()//libera leitura para lista acima
			.antMatchers(PUBLIC_MATCHERS).permitAll()//libera acesso para lista acima
			.anyRequest().authenticated();//pede autenticação para o resto
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
		return source;

	}
	
	@Bean
	public BCryptPasswordEncoder bcryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
