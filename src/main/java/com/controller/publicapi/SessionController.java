package com.controller.publicapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.AccountBean;
import com.bean.LoginBean;
import com.bean.ResponseBean;
import com.bean.RoleBean;
import com.bean.UserBean;
import com.repository.AccountRepository;
import com.repository.RoleRepository;
import com.repository.UserRepository;

@RestController
@RequestMapping("/public")
public class SessionController {

	@Autowired
	RoleRepository roleRepo;

	@Autowired
	AccountRepository accountRepo;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BCryptPasswordEncoder bcrypt;

	@PostMapping("/signup")
	public ResponseEntity<ResponseBean<UserBean>> signup(@RequestBody UserBean user) {

		UserBean dbUser = userRepository.findByEmail(user.getEmail());
		ResponseBean<UserBean> res = new ResponseBean<>();

		if (dbUser == null) {
			RoleBean role = roleRepo.findByRoleName("user");
			user.setRole(role);
			String encPassword = bcrypt.encode(user.getPassword());
			user.setPassword(encPassword);
			userRepository.save(user);
			

			AccountBean account = new AccountBean();
			account.setAccountName("cash");
			account.setBalance(0f);
			account.setCurrency("INR");
			account.setUser(user);
			user.getAccounts().add(account); 

			accountRepo.save(account);
			res.setData(user);
			
			
			res.setMsg("Signup done...");

			return ResponseEntity.ok(res);
		} else {
			res.setData(user);
			res.setMsg("Email Already Taken");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
		}
	}

	@PostMapping("/login")
	public ResponseEntity<?> authenticate(@RequestBody LoginBean login) {
		UserBean dbUser = userRepository.findByEmail(login.getEmail());

		if (dbUser == null || /*!dbUser.getPassword().equals(login.getPassword())*/ bcrypt.matches(login.getPassword(), dbUser.getPassword()) == false) {
			ResponseBean<LoginBean> res = new ResponseBean<>();
			res.setData(login);
			res.setMsg("Invalid Credentials");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(res);
		} else {
			ResponseBean<UserBean> res = new ResponseBean<>();
			res.setData(dbUser);
			res.setMsg("Login done...");
			return ResponseEntity.ok(res);
		}
	}

}