package com.ty.hospital_app.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital_app.dao.ItemsDao;
import com.ty.hospital_app.dto.Items;
import com.ty.hospital_app.dto.MedOrder;

public class ItemsDaoImp implements ItemsDao{

	public Items saveItems(int mId, Items item) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bhrs");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		MedOrder medOrder = entityManager.find(MedOrder.class, mId);
		if(medOrder!=null) {
			entityTransaction.begin();
			entityManager.persist(item);
			entityTransaction.commit();
			return item;
		}
		else {
			return null;
		}

	}

	public boolean deleteItem(int iId) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bhrs");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Items item = entityManager.find(Items.class, iId);
		
		if(item!= null) {
			entityTransaction.begin();
			entityManager.remove(item);
			entityTransaction.commit();
			return true;
		}
		else {
			return false; 
		} 
	}

	public Items getItemById(int iId) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bhrs");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Items item = entityManager.find(Items.class, iId);
		
		return item;
	}

	public Items updateItemById(int iId, Items item) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bhrs");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Items item1 = entityManager.find(Items.class, iId);
		if(item1!=null) {
			item1.setiName(item.getiName());
			item1.setQuantity(item.getQuantity());
			item1.setCost(item.getCost());
			entityTransaction.begin();
			entityManager.merge(item);
			entityTransaction.commit();
			return item;
		}
		else {
			return null;
		}
	}

	public List<Items> getAllItems() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bhrs");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery("select s from items s");
		List<Items>items = query.getResultList();
		return items;
	}

}
