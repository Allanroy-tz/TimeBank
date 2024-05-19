package vip.wtyz.service;

import vip.wtyz.pojo.Transaction;

import java.util.List;

public interface TransactionService {
    boolean addTransaction(Transaction transaction);

    List<Transaction> getAllTransactionsForTransferor(String TransferorId);

    List<Transaction> getAllTransactionsForTransferee(String TransfereeId);

    List<Transaction> getAllTransaction();

    boolean transferTimeSpent(String transferee, String transferor, int timeSpent);

    Transaction getTransactionByOrderId(String OrderId);

    Long getAllTransactionAmount();
}
