package com.ty.hospital_app.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital_app.dao.EncounterDao;
import com.ty.hospital_app.dto.Branch;
import com.ty.hospital_app.dto.Encounter;

public class EncounterDaoImp implements EncounterDao{

	public Encounter saveEncounter(int bId, Encounter encounter) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bhrs");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Branch branch = entityManager.find(Branch.class, bId);
		if(branch!=null) {
			entityTransaction.begin();
			entityManager.persist(encounter);
			entityTransaction.commit();
			return encounter;
		}
		else {
			return null;
		}
	}

	public boolean deleteEncounter(int eId) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bhrs");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Encounter encounter = entityManager.find(Encounter.class, eId);
		
		if(encounter!= null) {
			entityTransaction.begin();
			entityManager.remove(encounter);
			entityTransaction.commit();
			return true;
		}
		else {
			return false; 
		} 
	}

	public Encounter getEncounterById(int eId) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bhrs");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Encounter encounter = entityManager.find(Encounter.class, eId);
		
		return encounter;
	}

	public Encounter updateEncounterById(int eId, Encounter encounter) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bhrs");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Encounter encounter1 = entityManager.find(Encounter.class, eId);
		if(encounter1!=null) {
			encounter1.setReason(encounter.getReason());
			encounter1.setDateOfJoining(encounter.getDateOfJoining());
			encounter1.setDateOfDischarge(encounter.getDateOfDischarge());
			entityTransaction.begin();
			entityManager.merge(encounter);
			entityTransaction.commit();
			return encounter;
		}
		else {
			return null;
		}
	}

	public List<Encounter> getAllEncounter() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bhrs");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery("select s from encounter s");
		List<Encounter>encounter = query.getResultList();
		return encounter;
	}

}
