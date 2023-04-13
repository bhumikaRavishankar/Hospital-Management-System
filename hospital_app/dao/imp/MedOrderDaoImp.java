package com.ty.hospital_app.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital_app.dao.MedOrderDao;
import com.ty.hospital_app.dto.Encounter;
import com.ty.hospital_app.dto.MedOrder;
import com.ty.hospital_app.dto.Person;

public class MedOrderDaoImp implements MedOrderDao{

	public MedOrder saveMedOrder(int eId, MedOrder medOrder) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bhrs");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Encounter encounter = entityManager.find(Encounter.class, eId);
		if(encounter!=null) {
			entityTransaction.begin();
			entityManager.persist(medOrder);
			entityTransaction.commit();
			return medOrder;
		}
		else {
			return null;
		}
	}

	public boolean deleteMedOrder(int mId) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bhrs");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		MedOrder medOrder = entityManager.find(MedOrder.class, mId);
		
		if(medOrder!= null) {
			entityTransaction.begin();
			entityManager.remove(medOrder);
			entityTransaction.commit();
			return true;
		}
		else {
			return false; 
		} 
	}

	public MedOrder getMedOrderById(int mId) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bhrs");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		MedOrder medOrder = entityManager.find(MedOrder.class, mId);
		
		return medOrder;
	}

	public MedOrder updateMedOrderById(int mId, MedOrder medOrder) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bhrs");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		MedOrder medOrder1 = entityManager.find(MedOrder.class, mId);
		if(medOrder1!=null) {
			medOrder1.setdName(medOrder.getdName());
			medOrder1.setOrderDate(medOrder.getOrderDate());
			entityTransaction.begin();
			entityManager.merge(medOrder);
			entityTransaction.commit();
			return medOrder;
		}
		else {
			return null;
		}
	}

	public List<MedOrder> getAllMedOrders() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bhrs");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery("select s from medorder s");
		List<MedOrder>medOrder = query.getResultList();
		return medOrder;
	}

	public List<MedOrder> getMedOrderByDoctorName(String doctorName) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bhrs");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery("select s from medorder s where s.doctorName=?1");
		query.setParameter(1, doctorName);
		List<MedOrder>medOrderList = query.getResultList();
		return medOrderList;
	}

}
