package com.findyourperson.findyourperson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})

@SpringBootApplication
public class FindyourpersonApplication {

	public static void main(String[] args) {
		SpringApplication.run(FindyourpersonApplication.class, args);
	}

}
