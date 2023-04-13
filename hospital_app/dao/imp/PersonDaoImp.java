package com.ty.hospital_app.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital_app.dao.PersonDao;
import com.ty.hospital_app.dto.Encounter;
import com.ty.hospital_app.dto.Person;

public class PersonDaoImp implements PersonDao{

	public Person savePerson(int eId, Person person) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bhrs");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Encounter encounter = entityManager.find(Encounter.class, eId);
		if(encounter!=null) {
			entityTransaction.begin();
			entityManager.persist(person);
			entityTransaction.commit();
			return person;
		}
		else {
			return null;
		}
	}

	public boolean deletePerson(int pId) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bhrs");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Person person = entityManager.find(Person.class, pId);
		
		if(person!= null) {
			entityTransaction.begin();
			entityManager.remove(person);
			entityTransaction.commit();
			return true;
		}
		else {
			return false; 
		} 
	}

	public Person getPersonById(int pId) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bhrs");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Person person = entityManager.find(Person.class, pId);
		
		return person;
	}

	public Person updatePersonById(int pId, Person person) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bhrs");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Person person1 = entityManager.find(Person.class, pId);
		if(person1!=null) {
			person1.setpName(person.getpName());
			person1.setAge(person.getAge());
			person1.setAddress(person.getAddress());
			person1.setDOB(person.getDOB());
			person1.setEmail(person.getEmail());
			person1.setGender(person.getGender());
			person1.setPhno(person.getPhno());
			entityTransaction.begin();
			entityManager.merge(person);
			entityTransaction.commit();
			return person;
		}
		else {
			return null;
		}
	}

	public List<Person> getAllPersons() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bhrs");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery("select s from person s");
		List<Person>persons = query.getResultList();
		return persons;
	}

	public List<Person> getPersonByGender(String gender) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bhrs");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery("select s from person s where s.gender=?1");
		query.setParameter(1, gender);
		List<Person>persons = query.getResultList();
		return persons;
	}

	public List<Person> getPersonByPhone(long phone) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bhrs");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery("select s from person s where s.phone=?1");
		query.setParameter(1, phone);
		List<Person>persons = query.getResultList();
		return persons;
	}

	public List<Person> getPersonByAge(int age) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bhrs");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery("select s from person s where s.age=?1");
		query.setParameter(1, age);
		List<Person>persons = query.getResultList();
		return persons;
	}

}
