package com.database.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.database.entities.Employee;
import java.util.List;


public interface employeeRepo  extends JpaRepository<Employee, Integer>{
	
	public Employee  findById(int id);
	public Employee findByName(String name);

}
