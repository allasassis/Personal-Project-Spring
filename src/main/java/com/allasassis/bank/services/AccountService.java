package com.allasassis.bank.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.allasassis.bank.entities.Account;
import com.allasassis.bank.entities.Customer;
import com.allasassis.bank.repositories.AccountRepository;
import com.allasassis.bank.services.exceptions.DatabaseException;
import com.allasassis.bank.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository repository;

	public List<Account> findAll() {
		return repository.findAll();
	}
	
	public Account findById(Long id) {
		Optional<Account> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Account insert(Account obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Account update(Long id, Account obj) {
		try {
			Account entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	private void updateData(Account entity, Account obj) {
		entity.setNumber(obj.getNumber());
		entity.setType(obj.getType());
	}
}
