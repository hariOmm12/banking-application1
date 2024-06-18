package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.Account;
import com.example.demo.dao.AccountDTO;
import com.example.demo.dao.TransactionDTO;
import com.example.demo.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

	/*
	 * Account Creation: 
	 * Users should be able to create a new account by providing
	 * their name, email, phone number and password.
	 */
    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody AccountDTO accountDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(accountService.createAccount(accountDTO));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long id) {
        return ResponseEntity.ok(accountService.getAccountById(id));
    }

	/* Balance Enquiry: 
	 * Users should be able to check their account balance. */
    @GetMapping("/{id}/balance")
    public ResponseEntity<Double> getBalance(@PathVariable Long id) {
        return ResponseEntity.ok(accountService.getBalance(id));
    }

	/* Deposit:
	 *  Users should be able to deposit money into their account. */
    @PostMapping("/{id}/deposit")
    public ResponseEntity<Void> deposit(@PathVariable Long id, @RequestBody TransactionDTO transactionDTO) {
        accountService.deposit(id, transactionDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

	/* Withdrawal: 
	 * Users should be able to withdraw money from their account. */
    @PostMapping("/{id}/withdraw")
    public ResponseEntity<Void> withdraw(@PathVariable Long id, @RequestBody TransactionDTO transactionDTO) {
        accountService.withdraw(id, transactionDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    
    
}
