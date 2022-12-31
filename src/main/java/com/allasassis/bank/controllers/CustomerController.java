package com.allasassis.bank.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.allasassis.bank.entities.Customer;
import com.allasassis.bank.repositories.CustomerRepository;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;
	
	@GetMapping
	public List<Customer> findAll() {
		List<Customer> list = customerRepository.findAll();
		return list;
	}
}
