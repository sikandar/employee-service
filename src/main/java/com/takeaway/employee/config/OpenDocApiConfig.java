package com.takeaway.employee.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenDocApiConfig {

	@Bean
	public OpenAPI docConfig() {
		return new OpenAPI().components(new Components())
				.info(new Info().title("TakeAway - Employee Service")
				.description("Employee Service API REST Documentation"));
	}
}
