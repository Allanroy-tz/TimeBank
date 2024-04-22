package vip.wtyz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.wtyz.mapper.TransactionMapper;
import vip.wtyz.pojo.Transaction;
import vip.wtyz.service.TransactionService;

import java.util.List;

@Service
public class TransactionImpl implements TransactionService {
    @Autowired
    TransactionMapper transactionMapper;
    QueryWrapper<Transaction> queryWrapper = new QueryWrapper<>();

    @Override
    public boolean addTransaction(Transaction transaction) {
        return transactionMapper.insert(transaction) > 0;
    }

    @Override
    public List<Transaction> getAllTransactionsForTransferor(String TransferorId) {
        return transactionMapper.selectList(queryWrapper.eq("TransferorId", TransferorId));
    }

    @Override
    public List<Transaction> getAllTransactionsForTransferee(String TransfereeId) {
        return transactionMapper.selectList(queryWrapper.eq("TransfereeId", TransfereeId));
    }
}