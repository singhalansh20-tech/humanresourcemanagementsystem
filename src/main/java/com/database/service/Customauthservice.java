package com.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.database.entities.Employee;
import com.database.repo.employeeRepo;

@Service
public class Customauthservice implements UserDetailsService {
	
	@Autowired
	private employeeRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Employee emp = repo.findByName(username);
		if(emp==null) {
			throw new UsernameNotFoundException("Employee not found");
		}
		return  new User(emp.getName(),emp.getPassword(),List.of(new SimpleGrantedAuthority("ROLE_EMP")));
	}
	

}
