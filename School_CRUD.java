package com.ty.onetomany_uni1.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.onetomany_uni1.dto.School;
import com.ty.onetomany_uni1.dto.Student;

public class School_CRUD {
	
	public EntityManager geEntityManager()
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager;
	}

	public boolean saveSchool(School school)
	{
		EntityManager entityManager = geEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		School school2 = entityManager.find(School.class, school.getId());
		if (school2 == null) {
			entityTransaction.begin();
			school.setId(school.getId());

			entityManager.merge(school);
			entityTransaction.commit();
		} else {
			System.out.println("Id already exists");
		}
		return school2== null;
	}
	
	public void updateSchool(int id,School school)
	{
		EntityManager entityManager=geEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		School school2=entityManager.find(School.class, id);
		if(school2!=null)
		{
			school.setId(id);
			school.setList(school2.getList());
			entityTransaction.begin();
			entityManager.merge(school);
			entityTransaction.commit();
		}
		else
		{
			System.out.println("this school does not exist");
		}
	}
	
	public void deleteSchool(int id)
	{
		EntityManager entityManager=geEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		School school2=entityManager.find(School.class, id);
		if(school2!=null)
		entityTransaction.begin();
		entityManager.remove(school2);
		entityTransaction.commit();
	}
	
	public School getSchoolbyId(int id)
	{
		EntityManager entityManager=geEntityManager();
		School school=entityManager.find(School.class, id);
		return school;
	}
	
	public List<School> getAll()
	{
		EntityManager entityManager=geEntityManager();
		Query query=entityManager.createQuery("Select a from School a");
		List<School> list=query.getResultList();
		return list;
		
	}
	
}
