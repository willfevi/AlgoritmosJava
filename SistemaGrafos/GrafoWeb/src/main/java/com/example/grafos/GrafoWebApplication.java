package com.example.grafos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.example.grafos.controller","com.example.grafos.service","com.exemplo.grafos"})
public class GrafoWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrafoWebApplication.class, args);
	}

}
