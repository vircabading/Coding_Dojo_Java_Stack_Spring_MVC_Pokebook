package com.vcabading.pokebook.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vcabading.pokebook.models.Expense;
import com.vcabading.pokebook.services.ExpenseService;

/////////////////////////////////////////////////////////////
//	EXPENSE CONTROLLER
/////////////////////////////////////////////////////////////

@Controller
@RequestMapping("/expenses")
public class ExpenseController {
	
	//	//// FIELDS /////////////////////////////////////////
	
	@Autowired
	ExpenseService expService;
	
	//	//// POST ///////////////////////////////////////////
	
	@PostMapping("")
	public String expensesPost(
			@RequestParam("name") String name,
			@RequestParam("vendor") String vendor,
			@RequestParam("amount") double amount,
			@RequestParam("description") String description,
			HttpSession session) {
		session.setAttribute("name", name);
		session.setAttribute("vendor", vendor);
		session.setAttribute("amount", amount);
		session.setAttribute("description", description);
		
		if (name.length()>0 && vendor.length()>0 && description.length()>0 && amount > 0) {
			this.expService.createExpense(name, vendor, amount, description);
		}
		return "redirect:/expenses";
	}
	//	//// RETRIEVE ///////////////////////////////////////
	
	@GetMapping("")
	public String expenses(Model model) {
		List<Expense> expenses = this.expService.getAll();
		model.addAttribute("expenses",expenses);
		return "expenses.jsp";
	}
	
}
