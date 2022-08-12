package com.seed;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bean.RoleBean;
import com.repository.RoleRepository;

@Component
public class RoleSeed {
	@Autowired
	RoleRepository roleRepository;
	
	@PostConstruct //used on a method that needs to be executed after dependency injection is done to perform any initialization.
	void createRole() {
		RoleBean role = roleRepository.findByRoleName("user");
		if(role == null) {
			RoleBean role1 = new RoleBean();
			role1.setRoleName("user");
			roleRepository.save(role1);
			
			RoleBean role2 = new RoleBean();
			role2.setRoleName("admin");
			roleRepository.save(role2);
			System.out.println("Role Added....");
		} else {
			System.out.println("Role already added...");
		}
	}
}
