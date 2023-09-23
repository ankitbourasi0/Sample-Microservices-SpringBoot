package com.bourasi.movieinfoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieInfoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieInfoServiceApplication.class, args);
	}


	/*
	 * Now If U run this Service by default it run on port:8080 it clash b/w other microservices, they not conflict on production because most of the time microservices is run on different services 
	 * but can conflict on local server. 
	 * so for the server port configuration go to the application.properties and change the port by default port 
	 * for example:
	 * 			microservice1: port:8080
	 * 			microservice2: port:8081
	 * 			microservice3: port:8082
	 * 			so on...
	 *In Application.properties
	 *server.port=8081
	 */

}
