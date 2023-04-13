package com.ty.hospital_app.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital_app.dao.BranchDao;
import com.ty.hospital_app.dto.Branch;
import com.ty.hospital_app.dto.Hospital;

public class BranchDaoImp implements BranchDao {

	public Branch saveBranch(int hId, Branch branch) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bhrs");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Hospital hospital = entityManager.find(Hospital.class, hId);
		if(hospital!=null) {
			entityTransaction.begin();
			entityManager.persist(branch);
			entityTransaction.commit();
			return branch;
		}
		else {
			return null;
		}
	}

	public boolean deleteBranch(int bId) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bhrs");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Branch branch = entityManager.find(Branch.class, bId);
		
		if(branch!= null) {
			entityTransaction.begin();
			entityManager.remove(branch);
			entityTransaction.commit();
			return true;
		}
		else {
			return false; 
		} 
	}

	public Branch getBranchById(int bId) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bhrs");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Branch branch = entityManager.find(Branch.class, bId);
		
		return branch;
	}

	public Branch updateBranchById(int bId, Branch branch) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bhrs");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Branch branch1 = entityManager.find(Branch.class, bId);
		if(branch1!=null) {
			branch1.setbName(branch.getbName());
			branch1.setEmail(branch.getEmail());
			branch1.setPhno(branch.getPhno());
			entityTransaction.begin();
			entityManager.merge(branch);
			entityTransaction.commit();
			return branch;
		}
		else {
			return null;
		}
	}

	public List<Branch> getAllBranch() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bhrs");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery("select s from branch s");
		List<Branch>branch = query.getResultList();
		return branch;
	}

}



