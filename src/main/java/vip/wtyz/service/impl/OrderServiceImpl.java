package vip.wtyz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.wtyz.mapper.OrderListMapper;
import vip.wtyz.mapper.OrderMapper;
import vip.wtyz.pojo.OrderList;
import vip.wtyz.pojo.TimeOrder;
import vip.wtyz.service.OrderService;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;
    @Autowired
    OrderListMapper orderListMapper;
    QueryWrapper<TimeOrder> queryWrapper = new QueryWrapper<>();

    @Override
    public List<TimeOrder> getAllOrders() {
        return orderMapper.selectList(null);
    }

    @Override
    public List<TimeOrder> getAllOrdersExceptUser(String OpenId) {

        return orderMapper.selectList(queryWrapper.ne("OpenId", OpenId));
    }

    @Override
    public List<OrderList> getAllOrderListForUser(String OpenId) {
        return orderListMapper.GetAllOrderListByOpenId(OpenId);
    }

    @Override
    public List<OrderList> getAllAcceptedOrderListForUser(String AcceptOpenId) {
        return orderListMapper.GetAllOrderListByAcceptOpenId(AcceptOpenId);
    }


    @Override
    public boolean addOrder(TimeOrder timeOrder) {
        return orderMapper.insert(timeOrder) > 0;
    }

    @Override
    public boolean deleteOrder(String OrderId) {
        return orderMapper.deleteById(OrderId) > 0;
    }

    @Override
    public boolean updateOrder(TimeOrder timeOrder) {
        return orderMapper.updateById(timeOrder) > 0;
    }
}
