package com.ty.hospital_app.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital_app.dao.UserDao;
import com.ty.hospital_app.dto.Person;
import com.ty.hospital_app.dto.User;

public class UserDaoImp implements UserDao{

	public User saveUser(User user) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bhrs");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
		return user;
	}

	public boolean deleteUser(int uId) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bhrs");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		User user = entityManager.find(User.class, uId);
		
		if(user!= null) {
			entityTransaction.begin();
			entityManager.remove(user);
			entityTransaction.commit();
			return true;
		}
		else {
			return false; 
		} 
	}

	public User getUserById(int uId) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bhrs");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		User user = entityManager.find(User.class, uId);
		
		return user;
	}

	public User updateUserById(int uId, User user) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bhrs");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		User user1 = entityManager.find(User.class, uId);
		if(user!=null) {
			user1.setuName(user.getuName());
			user1.setEmail(user.getEmail());
			user1.setPassword(user.getPassword());
			user1.setPhno(user.getPhno());
			user1.setRole(user.getRole());
			entityTransaction.begin();
			entityManager.merge(user);
			entityTransaction.commit();
			return user;
		}
		else {
			return null;
		}
	}

	public List<User> getAllUsers() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bhrs");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery("select s from user s");
		List<User>users = query.getResultList();
		return users;
	}

	public List<User> getUserByRole(String role) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bhrs");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery("select s from user s where s.role=?1");
		query.setParameter(1, role);
		List<User>userList = query.getResultList();
		return userList;
	}

}
