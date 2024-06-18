package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dao.Account;
import com.example.demo.dao.AccountDTO;
import com.example.demo.dao.NotificationDTO;
import com.example.demo.dao.SecurityConfig;
import com.example.demo.dao.TransactionDTO;
import com.example.demo.exception.InsufficientFundsException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AccountRepository;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

	/*
	 * @Autowired private RestTemplate restTemplate;
	 */
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Account createAccount(AccountDTO accountDTO) {
    	validateAccountDTO(accountDTO);
        accountDTO.setPassword(passwordEncoder.encode(accountDTO.getPassword()));
        Account account = new Account(accountDTO);
        return accountRepository.save(account);
    }

    private void validateAccountDTO(AccountDTO accountDTO) {
        // Add validation logic here, e.g., check for null or empty fields
        if (accountDTO.getName() == null || accountDTO.getName().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (accountDTO.getEmail() == null || accountDTO.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
        if (accountDTO.getPhoneNumber() == null || accountDTO.getPhoneNumber().isEmpty()) {
            throw new IllegalArgumentException("Phone number cannot be null or empty");
        }
        if (accountDTO.getPassword() == null || accountDTO.getPassword().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }
    }
    
    public Double getBalance(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Account not found"));
        return account.getBalance();
    }
    
    public Account getAccountById(Long id) {
        return accountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Account not found"));
    }

    public void deposit(Long id, TransactionDTO transactionDTO) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Account not found"));
        account.setBalance(account.getBalance() + transactionDTO.getAmount());
        accountRepository.save(account);
        
        // Call Notification Service to send an email
        //restTemplate.postForObject("http://localhost:8083/notifications", new NotificationDTO(account.getEmail(), "Deposit", transactionDTO.getAmount()), Void.class);
    }

    public void withdraw(Long id, TransactionDTO transactionDTO) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Account not found"));
        if (account.getBalance() < transactionDTO.getAmount()) {
            throw new InsufficientFundsException("Insufficient funds");
        }
        account.setBalance(account.getBalance() - transactionDTO.getAmount());
        accountRepository.save(account);
        
        // Call Notification Service to send an email
        //restTemplate.postForObject("http://notification-service/notifications", new NotificationDTO(account.getEmail(), "Withdrawal", transactionDTO.getAmount()), Void.class);
    }
}
