package com.allasassis.bank.controllers;

import java.net.URI;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.allasassis.bank.entities.Account;
import com.allasassis.bank.services.AccountService;

@RestController
@RequestMapping(value = "/accounts")
public class AccountController {
	
	@Autowired
	private AccountService service;
	
	@GetMapping
	public ResponseEntity<List<Account>> findAll() {
		List<Account> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Account> findById(@PathVariable Long id) {
		Account account = service.findById(id);
		return ResponseEntity.ok().body(account);
	}
	
	@PostMapping
	public ResponseEntity<Account> insert(@RequestBody Account account) {
		account = service.insert(account);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(account.getId()).toUri();
		return ResponseEntity.created(uri).body(account);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);											
		return ResponseEntity.noContent().build();						 	
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Account> update(@PathVariable Long id, @RequestBody Account obj) {
		service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
	
	@PutMapping(value = "/deposit/{id}/{value}")
	 public ResponseEntity<Account> deposit(@PathVariable Long id, @PathVariable Double value) {
		Account x = service.findById(id);
		service.deposit(x, value);
		return ResponseEntity.ok().body(x);
	}
	
	@PutMapping(value = "/withdraw/{id}/{value}")
	 public ResponseEntity<Account> withdraw(@PathVariable Long id, @PathVariable Double value) {
		Account x = service.findById(id);
		service.withdraw(x, value);
		return ResponseEntity.ok().body(x);
	}
	
	@PutMapping(value = "/transfer/{id}/{id1}/{value}")
	public ResponseEntity<Account> transfer(@PathVariable Long id, @PathVariable Long id1, @PathVariable Double value) {
		Account acc1 = service.findById(id);
		Account acc2 = service.findById(id1);
		Account acc = service.transfer(acc1, acc2, value);
		return ResponseEntity.ok().body(acc);
	}
}
