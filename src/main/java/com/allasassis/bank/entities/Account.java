package com.allasassis.bank.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_account")
public class Account implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer number;
	private String type;
	// private Double balance;
	
	@OneToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	public Account() {
		
	}
	
	public Account(Long id, Integer number, String type, Customer customer) {
		super();
		this.id = id;
		this.number = number;
		this.type = type;
		this.customer = customer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/* public Double getBalance() {
		return balance;
	}
	
	public void withdraw(Double value) {
		this.balance = this.balance - value;
		System.out.println("Successful! Your balance now is: $ " + String.format("%.2f", getBalance())); 
	}
	
	public void deposit(Double value) {
		this.balance = this.balance - value;
		System.out.println("Successful! Your balance now is: $ " + String.format("%.2f", getBalance())); 
	} */
}
