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


    @Override
    public List<TimeOrder> getAllOrders() {
        return orderMapper.selectList(null);
    }

    @Override
    public List<TimeOrder> getAllOrdersExceptUser(String OpenId) {
        QueryWrapper<TimeOrder> queryWrapper = new QueryWrapper<>();
        return orderMapper.selectList(queryWrapper.ne("OpenId", OpenId).eq("OrderState", "0"));
    }

    @Override
    public List<OrderList> getAllOrderListForUser(String OpenId) {
        List<OrderList> orderLists = orderListMapper.GetAllOrderListByOpenId(OpenId);
        // 0 1 -1 2 -2  -3
        orderLists.sort((o1, o2) -> {
            int v1 = Integer.parseInt(o1.getOrderState());
            int v2 = Integer.parseInt(o2.getOrderState());
            if (v1 != v2) {
                if (Math.abs(v1) != Math.abs(v2)) return Math.abs(v1) - Math.abs(v2);
                else return v2 - v1;
            }
            return o1.getDateTime().compareTo(o2.getDateTime());
        });
        return orderLists;
    }

    @Override
    public List<OrderList> getAllAcceptedOrderListForUser(String AcceptOpenId) {
        List<OrderList> orderLists = orderListMapper.GetAllOrderListByAcceptOpenId(AcceptOpenId);
        orderLists.sort((o1, o2) -> {
            int v1 = Integer.parseInt(o1.getOrderState());
            int v2 = Integer.parseInt(o2.getOrderState());
            if (v1 != v2) {
                return v1 - v2;
            }
            return o1.getDateTime().compareTo(o2.getDateTime());
        });
        return orderLists;
    }


    @Override
    public boolean addOrder(TimeOrder timeOrder) {

        timeOrder.setOrderState("-1");
        timeOrder.setOrderId(null);
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

    @Override
    public boolean changeOrderState(Integer orderId, String state) {
        TimeOrder timeOrder = new TimeOrder();
        timeOrder.setOrderId(orderId);
        timeOrder.setOrderState(state);
        return orderMapper.updateById(timeOrder) > 0;
    }

    @Override
    public List<TimeOrder> getAllOrderListByState(String state) {
        QueryWrapper<TimeOrder> queryWrapper = new QueryWrapper<>();
        return orderMapper.selectList(queryWrapper.eq("OrderState", state));
    }

    @Override
    public boolean acceptOrder(Integer OrderId, String AcceptOpenId) {
        TimeOrder timeOrder = new TimeOrder();
        timeOrder.setOrderState("1");
        timeOrder.setAcceptOpenId(AcceptOpenId);
        timeOrder.setOrderId(OrderId);
        return orderMapper.updateById(timeOrder) > 0;
    }

    @Override
    public Long getAllOrderAmount() {
        return orderMapper.selectCount(null);
    }
}
