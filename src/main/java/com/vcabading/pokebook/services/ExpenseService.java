package com.vcabading.pokebook.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vcabading.pokebook.models.Expense;
import com.vcabading.pokebook.repositories.ExpenseRepository;

/////////////////////////////////////////////////////
// EXPENSE SERVICE
/////////////////////////////////////////////////////

@Service
public class ExpenseService {

	//	//// FIELDS /////////////////////////////////
	
	private final ExpenseRepository expenseRepo;
	
	//	//// CONSTRUCTORS ///////////////////////////
	
	public ExpenseService(ExpenseRepository expenseRepo) {
		this.expenseRepo = expenseRepo;
	}
	
	//	//// CREATE /////////////////////////////////
	
	//	---- Create an Expense ---------------------
	public Expense createExpense(Expense expense) {
		return this.expenseRepo.save(expense);
	}
	
	//	---- Create an Expense by Name, Vendor, Amount, Description 
	public Expense createExpense(String name, String vendor, double amount, String description) {
		Expense newExpense = new Expense(name, vendor, amount, description);
		return this.expenseRepo.save(newExpense);
	}
	
	//	//// RETRIEVE ///////////////////////////////
	
	//	---- Get All --------------------------------
	public List<Expense> getAll() {
		return this.expenseRepo.findAll();
	}
	
	
	public Expense findExpenseByID(Long id) {
		Optional<Expense> optExpense = this.expenseRepo.findById(id);
		if ( optExpense.isPresent() ) {
			return optExpense.get();			
		} else {
			return null;
		}
	}
	
	//	//// UPDATE /////////////////////////////////
	
	public Expense updateExpense(Long id, String name, 
			String vendor, double amount, String description) {
		Optional<Expense> optExpense = this.expenseRepo.findById(id);
		if ( optExpense.isPresent() ) {
			Expense expense = this.findExpenseByID(id);
			expense.setName(name);
			expense.setVendor(vendor);
			expense.setAmount(amount);
			expense.setDescription(description);
			return this.expenseRepo.save(expense);
		} else {
			return null;
		}
	}
	
	//	//// DELETE /////////////////////////////////
	
	public void deleteExpenseByID(Long id) {
		this.expenseRepo.deleteById(id);
	}
	
	
}
