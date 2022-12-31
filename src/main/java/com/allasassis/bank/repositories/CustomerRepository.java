package com.allasassis.bank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.allasassis.bank.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
