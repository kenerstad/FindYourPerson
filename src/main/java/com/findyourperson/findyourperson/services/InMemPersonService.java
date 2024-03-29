package com.findyourperson.findyourperson.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.findyourperson.findyourperson.persistence.model.PersonModel;


/*
 * Custom implementation of person service. Leverages ArrayList to store entity models & facilitate 
 * CRUD operations for PersonController. Id stored in idCounter property & handled by generateId() method.
 */
@Service("inMemPersonService")
public class InMemPersonService implements PersonService{

	private Long idCounter;
	private List<PersonModel> personStorage;
	
	
	public InMemPersonService() {		
		idCounter = (long) 0;
		personStorage = createMockPeople();
	}
	
	@Override
	public List<PersonModel> create(PersonModel person) {	
		Long id = generateId();
		try {
			personStorage.add(new PersonModel(id, person.getName(), person.getAge()));	
		}		
		catch (Exception e) {	
			e.printStackTrace();
			return null;
		}
		
		return personStorage;
	}

	@Override
	public List<PersonModel> getAll() {		
		return this.personStorage;
	}

	/*
	 * Iterates person list & checks for id property, 
	 * returns PersonModel if true, null if not. 
	 */
	@Override
	public PersonModel findById(Long id) {		
		for (PersonModel personInStorage : personStorage) {
			if (personInStorage.getId() == id)
				return personInStorage;
		}
		
		return null;
	}

	/*
	 * Iterates person list & checks for id property, 
	 * replaces found PersonModel object & returns the person list. 
	 */
	@Override
	public List<PersonModel> update(PersonModel person) {						
		Iterator<PersonModel> it = personStorage.iterator();
        while (it.hasNext()) {
        	PersonModel personInStorage = (PersonModel) it.next();
            if (personInStorage.getId() == person.getId()) {
            	int index = personStorage.indexOf(personInStorage);
            	try {
            		personStorage.set(index, person);
            	}
            	catch(Exception e) {
            		e.printStackTrace();
            	}           	
	        }	
		}
        
        return personStorage;
	}
	
	/*
	 * Used to receive an entire list of persons &
	 * check if there are new or deleted persons & updates 
	 * all other persons.
	 * ###
	 * New persons generated by front-end and not committed to 
	 * back-end storage, are given id < 0 & the assigned properties by front-end. If such are found,
	 * generates new person with the assigned properties of the checked person &
	 * inserted into person storage list. 
	 * ###
	 * Persons that have been deleted in frontend have deleted property checked.
	 * ###
	 * Iterates list & updates persons that are not deleted or new.
	 */
	@Override
	public List<PersonModel> save(List<PersonModel> people) {	
		for (PersonModel person : people) { // Check for new person created in frontend
			if(person.getId() < 0) {	
				try {
					personStorage.add(new PersonModel(generateId(), person.getName(), person.getAge()));
				}
				catch(Exception e) {
					e.printStackTrace();
				}				
			}
						
			else { // Checks for deleted person & Updates changed/unchanged persons.
				Iterator<PersonModel> it = personStorage.iterator();
		        while (it.hasNext()) {
		        	PersonModel personInStorage = (PersonModel) it.next();
		            if (personInStorage.getId() == person.getId()) {
		            	if(person.getName().compareTo("DELETED") == 0) {
		            		System.out.println("DELETING ID: " +person.getId());
		            		try {
		            			it.remove();
		            		}
		            		catch(Exception e) {
		            			e.printStackTrace();
		            		}
		            	}
		            	else {
		            		int index = personStorage.indexOf(personInStorage);
			            	try {
			            		personStorage.set(index, person);
			            	}
			            	catch(Exception e) {
			            		e.printStackTrace();
			            	}
		            	}		            			            	
			        }	
				}
			}			
		}
		
		return personStorage;
	}

	@Override
	public List<PersonModel> deleteById(Long id) {		
		Iterator<PersonModel> it = personStorage.iterator();
        while (it.hasNext()) {
        	PersonModel person = (PersonModel) it.next();
            if (person.getId() == id) {
            	try {
            		it.remove();
            	}
            	catch(Exception e) {
            		e.printStackTrace();
            	}               
                return personStorage;
            }         
        }
        return null;
	}
		
	/*
	 * Creates a mockup of persons & inserts into person list.
	 */
	private List<PersonModel> createMockPeople() {		
		List<PersonModel> persons = new ArrayList<PersonModel>();
		persons.add(new PersonModel(generateId(), "John Adams", 31));
		persons.add(new PersonModel(generateId(), "Steven Tyler", 22));
		persons.add(new PersonModel(generateId(), "Jenny Smith", 31));
		persons.add(new PersonModel(generateId(), "Brian Cox", 31));
		
		return persons;
	}
	
	/*
	 * Generates unique id for new PersonModel objects.
	 */
	private Long generateId() {
		
		return idCounter++;
	}
}

