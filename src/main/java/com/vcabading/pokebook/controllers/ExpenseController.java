package com.vcabading.pokebook.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	//	//// CREATE //////////////////////////////////////////
	
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
	
	// 	**** Get All ****************************************
	@GetMapping("")
	public String expenses(@ModelAttribute("expense") Expense expense, Model model) {
		List<Expense> expenses = this.expService.getAll();
		model.addAttribute("expenses",expenses);
		return "formform.jsp";
	}
	
	//	**** Get One by ID **********************************
	@GetMapping("/{id}")
	public String expensesID(@PathVariable("id") Long id, Model model) {
		Expense expense = this.expService.findExpenseByID(id);
		model.addAttribute("expense", expense);
		return "expensesid.jsp";
	}
	
	//	**** Get One by ID to SHOW EDIT FORM ****************
	@GetMapping("/{id}/edit")
	public String expensesIDEdit(@PathVariable("id") Long id, Model model) {
		Expense expense = this.expService.findExpenseByID(id);
		model.addAttribute("expense", expense);
		return "expensesidedit.jsp";
	}
	
	//	//// UPDATE //////////////////////////////////////////
	
	@PutMapping("/{id}/edit")
	public String expensesPost(	@Valid @ModelAttribute("expense") Expense expense,
								BindingResult result, Model model,
								@PathVariable("id") Long id) {
		if (result.hasErrors()) {									// If has errors
			expense = this.expService.findExpenseByID(id);	// 		Get Expense by ID
			model.addAttribute("expense", expense);					//		to re-populate edit form
            return "expensesidedit.jsp";
        } else {													// ELSE Update Expense Name, Vendor, Amount, Description
        	this.expService.updateExpense(id, expense.getName(), expense.getVendor(), expense.getAmount(), expense.getDescription());
            return "redirect:/expenses/" + expense.getId();
        }
	}
	
}