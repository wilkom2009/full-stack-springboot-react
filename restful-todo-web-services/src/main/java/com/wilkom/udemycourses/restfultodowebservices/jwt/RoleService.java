package com.wilkom.udemycourses.restfultodowebservices.jwt;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService implements Serializable{
	@Autowired
	private RoleRepository repository;
	
	Role findByName(String name) {
		return repository.save(new Role(name));
	}

}
