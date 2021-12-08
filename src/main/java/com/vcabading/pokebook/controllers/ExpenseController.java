package com.vcabading.pokebook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/////////////////////////////////////////////////////////////
//	EXPENSES CONTROLLER
/////////////////////////////////////////////////////////////

@Controller
@RequestMapping("/expenses")
public class ExpenseController {
	
	@GetMapping("")
	public String expenses() {
		return "expenses.jsp";
	}
}
