package com.allasassis.bank.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.allasassis.bank.entities.Customer;
import com.allasassis.bank.repositories.CustomerRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Customer user = new Customer(null, "Allas", "Software Engineer", "738.132.451-23");
		Customer user1 = new Customer(null, "Pedro", "Doctor", "321.421.122-23");
		Customer user2 = new Customer(null, "Sofia", "Lawyer", "812.321.451-23");
		customerRepository.saveAll(Arrays.asList(user, user1, user2));		
		
	}
	
	
}
