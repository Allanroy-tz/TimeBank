package vip.wtyz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.wtyz.mapper.TransactionMapper;
import vip.wtyz.mapper.UserMapper;
import vip.wtyz.pojo.Transaction;
import vip.wtyz.pojo.User;
import vip.wtyz.service.OrderService;
import vip.wtyz.service.TransactionService;

import java.util.List;

@Service
public class TransactionImpl implements TransactionService {
    @Autowired
    TransactionMapper transactionMapper;
    @Autowired
    OrderService orderService;

    @Override
    public boolean addTransaction(Transaction transaction) {

        boolean b = this.transferTimeSpent(transaction.getTransfereeId(), transaction.getTransferorId(), transaction.getTransferAmount());
        boolean b1 = orderService.changeOrderState(transaction.getOrderId(), "2");
        if (!b && !b1)
            return false;

        return transactionMapper.insert(transaction) > 0;
    }

    @Override
    public List<Transaction> getAllTransactionsForTransferor(String TransferorId) {
        QueryWrapper<Transaction> queryWrapper = new QueryWrapper<>();
        return transactionMapper.selectList(queryWrapper.eq("TransferorId", TransferorId));
    }

    @Override
    public List<Transaction> getAllTransactionsForTransferee(String TransfereeId) {
        QueryWrapper<Transaction> queryWrapper = new QueryWrapper<>();
        return transactionMapper.selectList(queryWrapper.eq("TransfereeId", TransfereeId));
    }

    @Override
    public List<Transaction> getAllTransaction() {
        return transactionMapper.selectList(null);
    }

    @Autowired
    UserMapper userMapper;

    @Override
    public boolean transferTimeSpent(String transferee, String transferor, int timeSpent) {
        User transfereeUser = userMapper.selectById(transferee);
        User transferorUser = userMapper.selectById(transferor);
        transfereeUser.AddTimeCredits(timeSpent);
        transferorUser.reduceTimeCredits(timeSpent);

        int i = userMapper.updateById(transfereeUser);
        int i1 = userMapper.updateById(transferorUser);
        return i > 0 && i1 > 0;
    }

    @Override
    public Transaction getTransactionByOrderId(String OrderId) {
        QueryWrapper<Transaction> queryWrapper = new QueryWrapper<>();
        return transactionMapper.selectList(queryWrapper.eq("OrderId", OrderId)).get(0);
    }

    @Override
    public Long getAllTransactionAmount() {
        return transactionMapper.selectCount(null);
    }
}
