package com.database.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.database.entities.Employee;
import com.database.service.Empservice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class controller {
	@Autowired
	private Empservice empservice;
	
	//getallemployee
	@GetMapping("/allemp")
	public List<Employee> getalluser(){
		 return empservice.getallemp();
		
	}
	//getemployeebyid
	@GetMapping("/employee/{id}")
	public Employee getbyid(@PathVariable("id") int id) {
		return empservice.getempbyid(id);
	}
	@Autowired
	private PasswordEncoder encoder;
	//createemp
	@PostMapping("/createmep")
	public void createemp(@RequestBody Employee employee) {
		employee.setPassword(encoder.encode(employee.getPassword()));
		empservice.createuser(employee);
	}
	
	//deleteempbyid
	@DeleteMapping("/delete/{id}")
	public void deleltebyid(@PathVariable("id") int id) {
		empservice.deletebyid(id);
	}
	
	//deleteallemp
	@DeleteMapping("/deleteall")
	public void deleteall() {
		empservice.deleteall();
	}
	
	//updateemp
	@PutMapping("/update/{id}")
	public void updatemp(@RequestBody Employee emp,@PathVariable("id") int id) {
		emp.setId(id);
		empservice.updateuser(emp, id);
	}
	

}
