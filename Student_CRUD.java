package com.ty.onetomany_uni1.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.mysql.cj.Query;
import com.ty.onetomany_uni1.dto.Student;

public class Student_CRUD {

	public EntityManager geEntityManager()
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager;
	}
	
	public void saveStudent(List<Student> slist) {
		EntityManager entityManager = geEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		for (Student student : slist) {
			entityTransaction.begin();
			entityManager.persist(student);
			entityTransaction.commit();
		}
	}
	public void updateStudent(Student student, int id) {
		EntityManager entityManager = geEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Student student1 = entityManager.find(Student.class, id);
		entityTransaction.begin();
		student1.setId(id);
		student1.setAddress(student.getAddress());
		entityManager.merge(student1);
		entityTransaction.commit();

	}
	
	public void deleteStudent(int id)
	{
		EntityManager entityManager=geEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Student student=entityManager.find(Student.class, id);
		student.setId(id);
		entityTransaction.begin();
		entityManager.remove(student);
		entityTransaction.commit();	
	}
	
	public Student getbyId(int id)
	{
		EntityManager entityManager=geEntityManager();
		Student student=entityManager.find(Student.class, id);
		return student;
	}
	public List<Student> getAllStudent()
	{
		EntityManager entityManager=geEntityManager();
		javax.persistence.Query query=entityManager.createQuery("Select s from student s");
		List<Student> list=query.getResultList();
		return list;
	}
}
