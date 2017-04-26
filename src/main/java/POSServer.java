package main.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
/**
 * Main class to initialize SpringBoot application
 * 
 * @author njoroge
 *
 */
@Configuration
@SpringBootApplication
public class POSServer {

	public static void main(String[] args) {
		//Start spring boot application
		SpringApplication.run(POSServer.class, args);
	}

}
