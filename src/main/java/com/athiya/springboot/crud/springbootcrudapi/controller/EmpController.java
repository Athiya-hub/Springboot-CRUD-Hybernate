package com.athiya.springboot.crud.springbootcrudapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.athiya.springboot.crud.springbootcrudapi.model.EmpModel;
import com.athiya.springboot.crud.springbootcrudapi.service.EmpServiceImpl;

@RestController
@RequestMapping("/api")
public class EmpController {

	@Autowired
	private EmpServiceImpl emps;
	
	@GetMapping("/employee")
	public List<EmpModel> get(){
		return emps.get();
	}
	
	@PostMapping("/employee")
	public EmpModel save(@RequestBody EmpModel empObject) {
		emps.save(empObject);
		return empObject;
	}
	
	@GetMapping("/employee/{id}")
	public EmpModel get(@PathVariable int id) {
		EmpModel empObject= emps.get(id);
		if(empObject==null) {
			throw new RuntimeException("Employee with id "+id+"is not found");
		}
		return empObject;
	}
	
	@DeleteMapping("/employee/{id}")
	public String delete(@PathVariable int id) {
		emps.delete(id);
		return "employee has been deleted with id"+id;
	}
	
	@PutMapping("/employee")
	public EmpModel update(@RequestBody EmpModel empObj)
	{
		emps.save(empObj);
		return empObj;
	}
}
