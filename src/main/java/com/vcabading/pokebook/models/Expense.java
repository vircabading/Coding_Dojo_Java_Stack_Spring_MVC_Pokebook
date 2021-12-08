package com.vcabading.pokebook.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

//////////////////////////////////////////////////////////////
// 	EXPENSE CLASS
//////////////////////////////////////////////////////////////

public class Expense {

	//	//// FIELDS //////////////////////////////////////////
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ID;
	
	@NotNull
	@Size(min=1, max=200, message="must enter a name")
	private String name;
	
	@NotNull
	@Size(min=1, max=200, message="must enter a vendor")
	private String vendor;
	
	@NotNull
	@Min(value=1, message="amount must be at least 1")
	private float amount;

	@NotNull
	@Size(min=1, max=400, message="must enter a description")
	private String description;
	
	@Column(updatable=false)		// this will not allow createdAt to be updated after creation
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	
	
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
