package com.findyourperson.findyourperson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import com.findyourperson.findyourperson.services.DbPersonService;

//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})

@SpringBootApplication
public class FindyourpersonApplication implements CommandLineRunner{

	@Autowired
	DbPersonService personService;
	
	public static void main(String[] args) {
		SpringApplication.run(FindyourpersonApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		personService.createMockPeople();
		
	}

}
