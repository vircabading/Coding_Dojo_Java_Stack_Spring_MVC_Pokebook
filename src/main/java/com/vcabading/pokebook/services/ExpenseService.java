package com.vcabading.pokebook.services;

import org.springframework.stereotype.Service;

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
	
	//	//// RETRIEVE ///////////////////////////////
	
	//	---- Get All --------------------------------
	public List<Expense> getAll() {
		return this.expenseRepo.findAll();
	}
	
	
	public Expense findExpenseByID(Long id) {
		Optional<Expense> optExpense = this.expenseRepo.findById(id);
		if ( optExpense.isPresent() ) {
			return optionalExpense.get();			
		} else {
			return null;
		}
	}
	
	//	//// UPDATE /////////////////////////////////
	
	//	//// DELETE /////////////////////////////////
	
	
}
