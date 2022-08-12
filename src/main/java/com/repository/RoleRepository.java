package com.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bean.RoleBean;

public interface RoleRepository extends CrudRepository<RoleBean, Integer> {
	List<RoleBean> findAll();

	RoleBean findByRoleName(String roleName);
}
