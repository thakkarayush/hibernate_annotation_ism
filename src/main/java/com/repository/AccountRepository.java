package com.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bean.AccountBean;

@Repository
public interface AccountRepository extends CrudRepository<AccountBean, Integer> {

}