package vip.wtyz;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vip.wtyz.pojo.Transaction;
import vip.wtyz.service.TransactionService;

@SpringBootTest
public class TransactionServiceTest {
    @Autowired
    TransactionService transactionService;

    @Test
    void insertTransactionTest() {
        Transaction transaction = new Transaction("123123", "123122", 222);
        transactionService.addTransaction(transaction);
    }
}
