package com.allasassis.bank.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.allasassis.bank.entities.Account;
import com.allasassis.bank.entities.Customer;
import com.allasassis.bank.repositories.AccountRepository;
import com.allasassis.bank.repositories.CustomerRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Customer user = new Customer(null, "Allas", "Software Engineer", "738.132.451-23");
		Customer user1 = new Customer(null, "Pedro", "Doctor", "321.421.122-23");
		Customer user2 = new Customer(null, "Sofia", "Lawyer", "812.321.451-23");
		customerRepository.saveAll(Arrays.asList(user, user1, user2));
		
		Account acc = new Account(null, 6783, "Personal", user, 2000.0);
		Account acc1 = new Account(null, 6761, "Real", user1, 1302.32);
		Account acc2 = new Account(null, 6724, "Personal", user2, 943.21);
		accountRepository.saveAll(Arrays.asList(acc, acc1, acc2));
	}
	
	
}
