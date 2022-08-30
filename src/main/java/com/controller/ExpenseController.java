package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("UserExpController")
public class ExpenseController {

	@GetMapping("addExp")
	public ModelAndView addExp() {
		return new ModelAndView("AddExp");
	}
}
