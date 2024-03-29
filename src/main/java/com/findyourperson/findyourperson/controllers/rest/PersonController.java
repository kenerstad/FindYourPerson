package com.findyourperson.findyourperson.controllers.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.findyourperson.findyourperson.persistence.model.PersonModel;
import com.findyourperson.findyourperson.services.PersonService;


@RestController	
@RequestMapping(value= {"api/person"})
public class PersonController {
	
	@Autowired
	@Qualifier("inMemPersonService")
	PersonService personService;
	
	
	@GetMapping(value="/getall", headers="Accept=application/json")
	public List<PersonModel> getAllPersons() {		
		return personService.getAll();
	}
	
	 @GetMapping(value = "/{id}", headers="Accept=application/json")
    public ResponseEntity<PersonModel> getPersonById(@PathVariable("id") Long id) {		 
		 PersonModel person = personService.findById(id);
		 if (person == null) {
			 return new ResponseEntity<PersonModel>(HttpStatus.NOT_FOUND);            
		 }
		 return new ResponseEntity<PersonModel>(person, HttpStatus.OK);       
    }
	 
	 @PostMapping(value="/create",headers="Accept=application/json")
	 public ResponseEntity<List<PersonModel>> createUser(@RequestBody PersonModel person) {		 
		 List<PersonModel> response = personService.create(person);
		 if (response == null) {
			 return new ResponseEntity<List<PersonModel>>(HttpStatus.BAD_REQUEST);
		 }		 
		 
		 return new ResponseEntity<List<PersonModel>>(response, HttpStatus.CREATED);
	 }
	 
	  @PutMapping(value="/update", headers="Accept=application/json")
	  public ResponseEntity<List<PersonModel>> updateUser(@RequestBody PersonModel currentPerson) {		  
		  PersonModel person = personService.findById(currentPerson.getId());
		  if (person == null) {
			  return new ResponseEntity<List<PersonModel>>(HttpStatus.NOT_FOUND);			            
		  }
		  
		  return new ResponseEntity<List<PersonModel>>(personService.update(currentPerson), HttpStatus.OK); 
	  }
	  
	  @PostMapping(value="/save",headers="Accept=application/json")
	    public List<PersonModel> save(@RequestBody List<PersonModel> persons) {			 		  		  			
		  return personService.save(persons);			 
	    }
	 
	  @PostMapping(value="/delete", headers ="Accept=application/json")
	  public ResponseEntity<List<PersonModel>> deleteUser(@RequestBody PersonModel person){		  
		  PersonModel personFound = personService.findById(person.getId());
		  if (personFound == null) {
			 return new ResponseEntity<List<PersonModel>>(HttpStatus.NOT_FOUND);
		 }
		  List<PersonModel> response = personService.deleteById(person.getId());
		  if(response == null) {
			  return new ResponseEntity<List<PersonModel>>(response, HttpStatus.BAD_REQUEST);			  
		  }
		  
		  return new ResponseEntity<List<PersonModel>>(response, HttpStatus.OK);		 
    }
}
