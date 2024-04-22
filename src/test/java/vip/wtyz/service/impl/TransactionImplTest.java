package vip.wtyz.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vip.wtyz.pojo.Transaction;
import vip.wtyz.service.TransactionService;

@SpringBootTest
class TransactionImplTest {
    @Autowired
    TransactionService transactionService;

    @Test
    void addTransaction() {
        Transaction transaction = new Transaction("123123", "123122", 222);
        transactionService.addTransaction(transaction);
    }

    @Test
    void getAllTransactionsForTransferor() {
        String TransferorId = "123123";
        System.out.println(transactionService.getAllTransactionsForTransferor(TransferorId));
    }

    @Test
    void getAllTransactionForTransferee() {
        String TransfereeId = "123122";
        System.out.println(transactionService.getAllTransactionsForTransferee(TransfereeId));
    }
}