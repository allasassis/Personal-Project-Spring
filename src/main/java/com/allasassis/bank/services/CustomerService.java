package com.allasassis.bank.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.allasassis.bank.entities.Customer;
import com.allasassis.bank.repositories.CustomerRepository;
import com.allasassis.bank.services.exceptions.DatabaseException;
import com.allasassis.bank.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public List<Customer> findAll() {
		return customerRepository.findAll();
	}
	
	public Customer findById(Long id) {
		Optional<Customer> obj = customerRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Customer insert(Customer obj) {
		return customerRepository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			customerRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Customer update(Long id, Customer obj) {
		try {
			Customer entity = customerRepository.getReferenceById(id);
			updateData(entity, obj);
			return customerRepository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	private void updateData(Customer entity, Customer obj) {
		entity.setName(obj.getName());
		entity.setProfession(obj.getProfession());
		entity.setCpf(obj.getCpf());
	}
}
