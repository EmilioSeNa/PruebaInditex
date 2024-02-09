package com.inditex.pruebaInditex.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AlbumsConfig {
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
