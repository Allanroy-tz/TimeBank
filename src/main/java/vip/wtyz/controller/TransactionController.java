package vip.wtyz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vip.wtyz.Utilities.ResultVO;
import vip.wtyz.pojo.Transaction;
import vip.wtyz.service.TransactionService;

@RestController
@CrossOrigin
@RequestMapping("transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @GetMapping("getAllTransaction")
    ResultVO GetAllTransaction() {
        return new ResultVO("200", transactionService.getAllTransaction());
    }

    @GetMapping("getAllTransactionsForTransferor")
    ResultVO GetAllTransactionsForTransferor(@RequestParam String TransferorId) {
        return new ResultVO("200", transactionService.getAllTransactionsForTransferor(TransferorId));
    }

    @GetMapping("getAllTransactionsForTransferee")
    ResultVO GetAllTransactionsForTransferee(@RequestParam String TransfereeId) {
        return new ResultVO("200", transactionService.getAllTransactionsForTransferee(TransfereeId));
    }

    @PostMapping("addTransaction")
    ResultVO AddTransaction(@RequestBody Transaction transaction) {
        boolean flag = transactionService.addTransaction(transaction);

        return new ResultVO(flag ? "200" : "201", flag ? "交易成功" : "交易失败");
//        Integer flag=transaction.getTransferAmount()+1;
//        System.out.println(transaction.getTransferAmount()+":::"+flag.toString());
//        return new ResultVO("","test");
    }
}
