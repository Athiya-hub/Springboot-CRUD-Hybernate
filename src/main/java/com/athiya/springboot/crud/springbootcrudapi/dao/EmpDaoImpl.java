package com.athiya.springboot.crud.springbootcrudapi.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.athiya.springboot.crud.springbootcrudapi.model.EmpModel;

@Repository
public class EmpDaoImpl implements EmpDaoI{

	@Autowired
	private EntityManager entityManager;
	@Override
	public List<EmpModel> get() {
		
		Session currentSession=entityManager.unwrap(Session.class);
		Query<EmpModel> query=currentSession.createQuery("from EmpModel",EmpModel.class);
		List<EmpModel> list=query.getResultList();
		return list;
	}

	@Override
	public EmpModel get(int id) {
		Session currentSession=entityManager.unwrap(Session.class);
		EmpModel empModelObject=currentSession.get(EmpModel.class, id);
		return empModelObject;
	}

	@Override
	public void save(EmpModel empmodel) {
		Session currentSession=entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(empmodel);
	}

	@Override
	public void delete(int id) {
		Session currentSession=entityManager.unwrap(Session.class);
		EmpModel empObject=currentSession.get(EmpModel.class, id);
		currentSession.delete(empObject); 
	}

}
