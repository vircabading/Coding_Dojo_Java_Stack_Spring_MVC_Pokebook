package com.vcabading.pokebook.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vcabading.pokebook.models.Expense;

////////////////////////////////////////////////////////////////
//	EXPENSE REPOSITORY
////////////////////////////////////////////////////////////////

@Repository
public interface ExpenseRepository extends CrudRepository<Expense, Long> {

	//	---- Retrieves all books -------------------------------
	List<Expense> findAll();
	
	Expense findByID(Long id);
	
	Expense deleteByID(Long id);	
}
