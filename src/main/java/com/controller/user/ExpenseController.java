package com.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.ExpenseBean;
import com.repository.ExpenseRepository;

@RestController
@RequestMapping("/user")
public class ExpenseController {

	@Autowired
	ExpenseRepository expRepo;

	@PostMapping("/expense")
	public ResponseEntity<?> addExpense(@RequestBody ExpenseBean expenseBean) {

		expRepo.save(expenseBean);
		return ResponseEntity.ok(expenseBean);
	}

	@GetMapping("/expense/{userId}")
	public ResponseEntity<?> addExpense(@PathVariable("userId") Integer userId) {
		List<ExpenseBean> expenses = expRepo.findByUserUserId(userId);
		return ResponseEntity.ok(expenses);
	}
}