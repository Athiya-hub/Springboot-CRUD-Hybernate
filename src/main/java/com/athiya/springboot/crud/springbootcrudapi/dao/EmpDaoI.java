package com.athiya.springboot.crud.springbootcrudapi.dao;

import java.util.List;

import com.athiya.springboot.crud.springbootcrudapi.model.EmpModel;

public interface EmpDaoI {

	List<EmpModel> get();
	
	EmpModel get(int id);
	
	void save (EmpModel empmodel);
	
	void delete(int id);
	
}
