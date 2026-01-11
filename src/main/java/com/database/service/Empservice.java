package com.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.database.entities.Employee;
import com.database.repo.employeeRepo;

@Service
public class Empservice {
	@Autowired
	private employeeRepo emprepo;
	
	
	//getallEmployee
	public List<Employee> getallemp(){
		return emprepo.findAll();
	}
	
	// getEmployeebyid
	public Employee getempbyid(int id) {
		return emprepo.findById(id);
	}
	
	//createuser
	public void createuser(Employee employee) {
		emprepo.save(employee);
	}
	// deletebyid
	public void deletebyid(int id) {
		emprepo.deleteById(id);
	}
	//deleteallemployee
	public void deleteall() {
		emprepo.deleteAll();
	}
	//updateEmployee
	
	public void updateuser(Employee newemp,int id) {
		newemp.setId(id);
		emprepo.save(newemp);
	}

}
