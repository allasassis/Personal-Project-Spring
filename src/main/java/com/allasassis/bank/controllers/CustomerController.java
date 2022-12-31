package com.allasassis.bank.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.allasassis.bank.entities.Customer;
import com.allasassis.bank.repositories.CustomerRepository;
import com.allasassis.bank.services.CustomerService;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping
	public List<Customer> findAll() {
		List<Customer> list = customerRepository.findAll();
		return list;
	}
	
	@GetMapping(value = "/{id}")
	public Customer findById(@PathVariable Long id) {
		Customer customer = customerRepository.findById(id).get();
		return customer;
	}
	
	@PostMapping
	public void insertCustomer(@RequestBody Customer customer) {
		customerRepository.save(customer);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
		customerService.delete(id);											
		return ResponseEntity.noContent().build();						 	
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Customer> update(@PathVariable Long id, @RequestBody Customer obj) {
		customerService.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
