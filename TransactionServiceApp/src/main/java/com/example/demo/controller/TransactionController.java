package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.Transaction;
import com.example.demo.service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

	/*
	 * Transaction History:
	 *  Users should be able to view their transaction history.
	 */
    @GetMapping("/{accountId}")
    public ResponseEntity<List<Transaction>> getTransactionHistory(@PathVariable Long accountId) {
        return ResponseEntity.ok(transactionService.getTransactionHistory(accountId));
    }

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
        return ResponseEntity.status(HttpStatus.CREATED).body(transactionService.createTransaction1(transaction));
    }
    
    
	/*
	 * @PostMapping("/transfer") public Transaction transfer(@RequestParam Long
	 * fromAccountId,
	 * 
	 * @RequestParam Long toAccountId,
	 * 
	 * @RequestParam Double amount,
	 * 
	 * @RequestParam String email) { return
	 * transactionService.transfer(fromAccountId, toAccountId, amount, email); }
	 */
}
