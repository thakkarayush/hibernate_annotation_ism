package com.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.AccountBean;
import com.bean.ResponseBean;
import com.repository.AccountRepository;

@RestController
@RequestMapping("/user")
public class AccountController {

	@Autowired
	AccountRepository accountRepo;
	
	@PostMapping("/account")
	public ResponseEntity<?> addAccount(@RequestBody AccountBean account){
		
		System.out.println(account.getUser());
		System.out.println(account.getUser().getUserId());
		accountRepo.save(account);
		ResponseBean<AccountBean> res = new ResponseBean<>();
		res.setData(account);
		res.setMsg("account added");
		
		return ResponseEntity.ok(res);
	}
}