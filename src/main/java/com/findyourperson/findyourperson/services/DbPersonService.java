package com.findyourperson.findyourperson.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.findyourperson.findyourperson.persistence.dao.PersonRepo;
import com.findyourperson.findyourperson.persistence.model.PersonModel;

/*
 * DB implementation of person service, currently leveraging H2 memory database. 
 * See: application.properties for settings.
 * NOTE: Experiencing issues with saving PersonModel objects to personRepo so it's disabled for now.
 */
@Service("dBPersonService")
public class DbPersonService implements PersonService{

	@Autowired
	PersonRepo personRepo;
	
	
	public DbPersonService() {		
		//createMockPeople();		
	}
	
	@Override
	public List<PersonModel> create(PersonModel person) {
		return null;
	}

	@Override
	public List<PersonModel> getAll() {		
		return (List<PersonModel>) personRepo.findAll();
	}

	@Override
	public PersonModel findById(Long id) {
		return null;
	}

	@Override
	public List<PersonModel> update(PersonModel person) {
		return null;
		
	}

	@Override
	public List<PersonModel> deleteById(Long id) {
		return null;
	}
	
	@Override
	public List<PersonModel> save(List<PersonModel> people) {		
		return null;
	}
	
	private void createMockPeople() {		
		personRepo.save(new PersonModel("JK Rowlings", 44));
		personRepo.save(new PersonModel("DB Weiss", 44));
		personRepo.save(new PersonModel("DB Man", 33));
	}
}
