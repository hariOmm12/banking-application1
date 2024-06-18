/*
 * package com.example.demo;
 * 
 * import static org.junit.Assert.assertEquals; import static
 * org.mockito.ArgumentMatchers.any; import static org.mockito.Mockito.when;
 * 
 * import java.time.LocalDateTime;
 * 
 * import org.junit.Test; import org.junit.runner.RunWith; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.context.SpringBootTest; import
 * org.springframework.boot.test.mock.mockito.MockBean;
 * 
 * import com.example.demo.dao.Transaction; import
 * com.example.demo.repository.TransactionRepository; import
 * com.example.demo.service.TransactionService; import
 * org.springframework.test.context.junit4.SpringRunner;
 * 
 * @RunWith(SpringRunner.class)
 * 
 * @SpringBootTest public class TransactionServiceTests {
 * 
 * @Autowired private TransactionService transactionService;
 * 
 * @MockBean private TransactionRepository transactionRepository;
 * 
 * @Test public void testCreateTransaction() { Transaction transaction = new
 * Transaction(); transaction.setAccountId(1L); transaction.setAmount(100.0);
 * transaction.setType("DEPOSIT");
 * transaction.setTimestamp(LocalDateTime.now());
 * when(transactionRepository.save(any(Transaction.class))).thenReturn(
 * transaction); Transaction createdTransaction =
 * transactionService.createTransaction(transaction); assertEquals(100.0,
 * createdTransaction.getAmount(), 0.0); } }
 */