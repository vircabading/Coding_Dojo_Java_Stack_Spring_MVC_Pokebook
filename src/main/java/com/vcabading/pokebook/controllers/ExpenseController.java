package com.vcabading.pokebook.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@PostMapping("")
    public String expensesPost(
    			@RequestParam("name") String name,
    			@RequestParam("vendor") String vendor,
    			@RequestParam("amount") float amount,
    			@RequestParam("description") String description,
    			HttpSession session) {
		session.setAttribute("name", name);
		session.setAttribute("vendor", vendor);
		session.setAttribute("amount", amount);
		session.setAttribute("description", description);
		
		return "redirect:/expenses";
    }
}
