package vip.wtyz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vip.wtyz.service.TransactionService;

@SpringBootTest
public class TransactionServiceTest {
    @Autowired
    TransactionService transactionService;

}
