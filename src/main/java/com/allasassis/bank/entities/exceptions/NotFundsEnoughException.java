package com.allasassis.bank.entities.exceptions;

public class NotFundsEnoughException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public NotFundsEnoughException() {
		super("Error, you don't have enough funds on your account to do this withdraw.");
	}
	
	
}
