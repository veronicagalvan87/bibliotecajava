package org.empleodigital.config;

import org.empleodigital.domain.service.ServicioAutoidentificacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpringConfiguracionSeguridad extends WebSecurityConfigurerAdapter {

@Autowired
private ServicioAutoidentificacion servicioautoidentificacion;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(servicioautoidentificacion)
			.passwordEncoder(encoder());

	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/libros/**", "/autores/**" , "/categorias/**" , "/prestamos/admin/**").hasRole("ADMINISTRADOR")
				.anyRequest().permitAll()
		.and()
			.formLogin()
				.loginPage("/login")
				.loginProcessingUrl("/autentificar")
				.defaultSuccessUrl("/pizzas")
				.failureUrl("/login?errorlogin=true")
				.usernameParameter("usuario")
				.passwordParameter("password")
				
			.and()
				.logout()
					.logoutUrl("/salir")
					.logoutSuccessUrl("/login?salir=true");
	}
	
	@Bean
	public BCryptPasswordEncoder encoder(){
		return new BCryptPasswordEncoder();
	}
	
	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println(encoder.encode("admin"));
	}
	
}
