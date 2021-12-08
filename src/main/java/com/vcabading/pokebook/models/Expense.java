package com.vcabading.pokebook.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

//////////////////////////////////////////////////////////////
// 	EXPENSE CLASS
//////////////////////////////////////////////////////////////

public class Expense {

	//	//// FIELDS //////////////////////////////////////////
	
	private long ID;
	
	@Size(min=1, message="must enter a name")
	private String name;
	
	@Size(min=1, message="must enter a vendor")
	private String vendor;
	
	@Min(value=1, message="amount must be at least 1")
	private float amount;
	
	@Size(min=1, message="must enter a description")
	private String description;
	
	//	//// CONSTRUCTORS /////////////////////////////////////
	
	public Expense() {
	}
	
	public Expense(String name, String vendor, float amount, String description) {
		this.name = name;
		this.vendor = vendor;
		this.amount = amount;
		this.description = description;
	}
}
