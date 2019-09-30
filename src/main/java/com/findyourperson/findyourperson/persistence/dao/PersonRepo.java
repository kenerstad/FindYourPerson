package com.findyourperson.findyourperson.persistence.dao;

import org.springframework.data.repository.CrudRepository;

import com.findyourperson.findyourperson.persistence.model.PersonModel;


public interface PersonRepo extends CrudRepository<PersonModel, Integer>{

	public PersonModel findById(Long id);
	public PersonModel findByName(String name);
}
