package com.ty.hospital_app.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital_app.dao.AddressDao;
import com.ty.hospital_app.dto.Address;
import com.ty.hospital_app.dto.Branch;

public class AddressDaoImp implements AddressDao{

	public Address saveAddress(int bId, Address address) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bhrs");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Branch branch = entityManager.find(Branch.class, bId);
		if(branch!=null) {
			entityTransaction.begin();
			entityManager.persist(address);
			entityTransaction.commit();
			return address;
		}
		else {
			return null;
		}
	}

	public boolean deleteAddress(int aId) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bhrs");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Address address = entityManager.find(Address.class, aId);
		
		if(address!= null) {
			entityTransaction.begin();
			entityManager.remove(address);
			entityTransaction.commit();
			return true;
		}
		else {
			return false; 
		} 
	}

	public Address getAddressById(int aId) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bhrs");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Address address = entityManager.find(Address.class, aId);
		
		return address;
	}

	public Address updateAddressById(int aId, Address address) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bhrs");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Address address1 = entityManager.find(Address.class, aId);
		if(address1!=null) {
			address1.setCountry(address.getCountry());
			address1.setState(address.getState());
			address1.setStreet(address.getStreet());
			entityTransaction.begin();
			entityManager.merge(address);
			entityTransaction.commit();
			return address;
		}
		else {
			return null;
		}
	}

	public List<Address> getAllAddress() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bhrs");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery("select s from address s");
		List<Address>address = query.getResultList();
		return address;
	}

}
