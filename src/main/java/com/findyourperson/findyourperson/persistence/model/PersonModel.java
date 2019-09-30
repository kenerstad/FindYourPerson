package com.findyourperson.findyourperson.persistence.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "person")
public class PersonModel {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
	private Long id;
	
	@Size(max = 36)
	private String name;
	
	private int age;	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public PersonModel() {
		
	}
	
	public PersonModel(String name, int age) {
			
		this.name = name;
		this.age = age;
	}
	
	public PersonModel(Long id, String name, int age) {
		
		this.id = id;		
		this.name = name;
		this.age = age;
	}	
}
