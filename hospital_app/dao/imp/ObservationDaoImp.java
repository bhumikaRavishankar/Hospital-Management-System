package com.ty.hospital_app.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital_app.dao.ObservationDao;
import com.ty.hospital_app.dto.Encounter;
import com.ty.hospital_app.dto.Observation;
import com.ty.hospital_app.dto.Person;

public class ObservationDaoImp implements ObservationDao {

	public Observation saveObservation(int eId, Observation observation) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bhrs");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Encounter encounter = entityManager.find(Encounter.class, eId);
		if(encounter!=null) {
			entityTransaction.begin();
			entityManager.persist(observation);
			entityTransaction.commit();
			return observation;
		}
		else {
			return null;
		}
	}

	public boolean deleteObservation(int oId) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bhrs");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Observation observation = entityManager.find(Observation.class, oId);
		
		if(observation!= null) {
			entityTransaction.begin();
			entityManager.remove(observation);
			entityTransaction.commit();
			return true;
		}
		else {
			return false; 
		} 
	}

	public Observation getObservationById(int oId) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bhrs");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Observation observation = entityManager.find(Observation.class, oId);
		
		return observation;
	}

	public Observation updateObservationById(int oId, Observation observation) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bhrs");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Observation observation1 = entityManager.find(Observation.class, oId);
		if(observation1!=null) {
			observation1.setdName(observation.getdName());
			observation1.setrObservation(observation.getrObservation());
			entityTransaction.begin();
			entityManager.merge(observation);
			entityTransaction.commit();
			return observation;
		}
		else {
			return null;
		}
	}

	public List<Observation> getAllObservations() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bhrs");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery("select s from observation s");
		List<Observation>observation = query.getResultList();
		return observation;
	}

	public List<Observation> getObservationByDoctorName(String doctorName) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bhrs");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery("select s from observation s where s.doctorName=?1");
		query.setParameter(1, doctorName);
		List<Observation>observationList = query.getResultList();
		return observationList;
	}
	
}
