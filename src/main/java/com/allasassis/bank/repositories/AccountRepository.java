package com.allasassis.bank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.allasassis.bank.entities.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

}
