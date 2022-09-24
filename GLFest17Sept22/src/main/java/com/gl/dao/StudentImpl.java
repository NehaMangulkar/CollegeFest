package com.gl.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gl.model.Student;

@Repository
public class StudentImpl implements StudentDao {
	@Autowired
	SessionFactory factory;
	
	@Transactional
	public void saveOrUpdate(Student student) {
		Session currentSession=factory.getCurrentSession();
		currentSession.saveOrUpdate(student);

	}

	@Transactional
	public void delete(int id) {
		Session currentSession=factory.getCurrentSession();
		Student theStudent= currentSession.get(Student.class, id);
		currentSession.delete(theStudent);

	}
	@Transactional
	public Student findById(int id) {
		Session currentSession=factory.getCurrentSession();
		Student theStudent= currentSession.get(Student.class, id);
		return theStudent;
	}
	@Transactional
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		Session currentSession=factory.getCurrentSession();
		Criteria c= currentSession.createCriteria(Student.class);
		return c.list();
	}

}
