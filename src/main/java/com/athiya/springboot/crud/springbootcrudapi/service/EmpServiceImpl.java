package com.athiya.springboot.crud.springbootcrudapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.athiya.springboot.crud.springbootcrudapi.dao.EmpDaoI;
import com.athiya.springboot.crud.springbootcrudapi.model.EmpModel;

@Service
public class EmpServiceImpl implements EmpService{

	@Autowired
	private EmpDaoI emp;
	
	@Transactional
	@Override
	public List<EmpModel> get() {
		return emp.get();
	}

	@Transactional
	@Override
	public EmpModel get(int id) {
		
		return emp.get(id);
	}

	@Transactional
	@Override
	public void save(EmpModel empmodel) {
		emp.save(empmodel);
		
	}

	@Transactional
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		emp.delete(id);
		
	}

}
