package br.senai.sp.cadastro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ClienteApplication implements WebMvcConfigurer{

	
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("http://localhost:3000").allowedMethods("GET", "POST", "DELETE", "OPTIONS", "PUT");
	}
	public static void main(String[] args) {
		SpringApplication.run(ClienteApplication.class, args);
	}

}
