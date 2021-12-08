package com.vcabading.pokebook.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public String expensesPost(@Valid @ModelAttribute("expense") Expense expense,
				BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<Expense> expenses = this.expService.getAll();
			model.addAttribute("expenses",expenses);
            return "formform.jsp";
        } else {
            this.expService.createExpense(expense.getName(), expense.getVendor(), expense.getAmount(), expense.getDescription());
            return "redirect:/expenses";
        }
	}
	//	//// RETRIEVE ///////////////////////////////////////
	
	@GetMapping("")
	public String expenses(@ModelAttribute("expense") Expense expense, Model model) {
		List<Expense> expenses = this.expService.getAll();
		model.addAttribute("expenses",expenses);
		return "formform.jsp";
	}
}