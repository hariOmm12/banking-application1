package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
	
	Account findByEmail(String email);
}
