package com.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bean.ExpenseBean;

@Repository
public interface ExpenseRepository extends CrudRepository<ExpenseBean, Integer> {
	List<ExpenseBean> findByUserUserId(Integer userId);

}