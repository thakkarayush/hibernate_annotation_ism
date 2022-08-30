package com.seed;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bean.RoleBean;
import com.repository.RoleRepository;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

@Slf4j
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
			log.error("hello");
			log.info("hello");
			System.out.println("Role already added...");
		}
	}
}
