package com.bourasi.MovieCatalougeApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MovieCatalougeAppApplication {
	/*
	 * How do you create an instance of any object in any spring application and have it share across mulitple other clases: Create a Bean
	 * Bean are by default singelton
	 * and Spring going to be hold a BEAN of type RESTTEMPLATE 
	 * and use it via autowired
	 * 
	 */
	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
	public static void main(String[] args) {
		SpringApplication.run(MovieCatalougeAppApplication.class, args);
	}

}
