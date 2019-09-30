package com.findyourperson.findyourperson.services;

import java.util.List;

import com.findyourperson.findyourperson.persistence.model.PersonModel;

public interface PersonService {

	public List<PersonModel> create(PersonModel person);
	public List<PersonModel> getAll();
	public PersonModel findById(Long id);
	public List<PersonModel> update(PersonModel person);
	public List<PersonModel> save(List<PersonModel> people);
	public List<PersonModel> deleteById(Long id);
	
}
