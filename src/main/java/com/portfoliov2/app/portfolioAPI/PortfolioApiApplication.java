package com.portfoliov2.app.portfolioAPI;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PortfolioApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortfolioApiApplication.class, args);
	}


	// Swagger configuration
	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI().info(new Info().title("Portfolio API").version("2.0").description("Portfolio API made with Spring Boot 3, JPA, JWT and Swagger. Good practices and quality work.").termsOfService("http://swagger.io/terms/").license(new License().name("Apache 2.0").url("http://springdoc.org")));
	}

}
