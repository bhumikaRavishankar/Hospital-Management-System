package com.ty.hospital_app.dao;

import java.util.List;

import com.ty.hospital_app.dto.Person;

public interface PersonDao {
	
	public Person savePerson(int eId, Person person);
	public boolean deletePerson(int pId);
	public Person getPersonById(int pId);
	public Person updatePersonById(int pId, Person person);
	public List<Person> getAllPersons();
	public List<Person> getPersonByGender(String gender);
	public List<Person> getPersonByPhone(long phone);
	public List<Person> getPersonByAge(int age);
	
}
