package com.ty.hospital_app.service;

import com.ty.hospital_app.dao.imp.PersonDaoImp;
import com.ty.hospital_app.dto.Person;

public class PersonService {
	
	public void savePerson(int eId, Person person) 
	{
		PersonDaoImp persondaoimp = new PersonDaoImp();
		Person person2 = persondaoimp.savePerson(eId, person);
		if(person2 != null)
		{
			System.out.println("Person saved");
		}
		else {
			System.out.println("Unfortunately person not saved");
		}
	}
	public Person getPersonId(int pId)
	{
		PersonDaoImp persondaoimp = new PersonDaoImp();
		Person person = persondaoimp.getPersonById(pId);
		if(person!=null)
		{
			return person;
		}
		else {
			return null;
		}
	}
	public void deletePersonId(int pId)
	{
		PersonDaoImp persondaoimp = new PersonDaoImp();
		Person person = persondaoimp.getPersonById(pId);
		boolean flag = persondaoimp.deletePerson(pId);
		if(flag)
		{
			System.out.println("Person deleted");
		}
		else {
			System.out.println("Person not found");
		}
	}
	public Person updatePerson(int pId, Person person)
	{
		PersonDaoImp persondaoimp = new PersonDaoImp();
		Person person1 = persondaoimp.updatePersonById(pId, person);
		if(person1!= null)
		{
			return person1;
		}
		else {
			return null;
		}
	}
	
}
