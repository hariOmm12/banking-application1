package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.Transaction;
import com.example.demo.repository.TransactionRepository;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;
    
    @Autowired
    private NotificationClient notificationClient;

    public List<Transaction> getTransactionHistory(Long accountId) {
        return transactionRepository.findByAccountId(accountId);
    }
    
    public Transaction createTransaction(Transaction transaction) {
       return transactionRepository.save(transaction);
    }

    public Transaction createTransaction1(Transaction transaction) {
        //return transactionRepository.save(transaction);
        
    	 Transaction transaction1 = new Transaction();
         transaction1.setAccountId(transaction.getAccountId());
         transaction1.setAmount(transaction.getAmount());
         transactionRepository.save(transaction1);

         // Send notification
         String subject = "Transaction Notification";
         String text = "A transaction of amount " + transaction.getAmount() + " has been made from your account.";
         String email = "rupallidas.job@gmail.com";
         notificationClient.sendNotification(email, transaction.getAmount());

         return transaction1;
    }
    
	/*
	 * public Transaction transfer(Long fromAccountId, Long toAccountId, Double
	 * amount, String email) { // Implement transfer logic, updating both accounts
	 * and saving transactions Transaction transaction = new Transaction();
	 * transaction.setAccountId(toAccountId); transaction.setAmount(amount);
	 * transactionRepository.save(transaction);
	 * 
	 * // Send notification String subject = "Transaction Notification"; String text
	 * = "A transaction of amount " + amount + " has been made from your account.";
	 * notificationClient.sendTransactionNotification(email, subject, text);
	 * 
	 * return transaction; }
	 */
}


