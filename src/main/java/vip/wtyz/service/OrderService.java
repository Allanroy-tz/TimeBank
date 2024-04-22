package vip.wtyz.service;

import vip.wtyz.pojo.OrderList;
import vip.wtyz.pojo.TimeOrder;

import java.util.List;

public interface OrderService {
    List<TimeOrder> getAllOrders();

    List<TimeOrder> getAllOrdersExceptUser(String OpenId);

    List<OrderList> getAllOrderListForUser(String OpenId);

    List<OrderList> getAllAcceptedOrderListForUser(String AcceptOpenId);

    //TODO 返回值类型有待确认
    boolean addOrder(TimeOrder timeOrder);

    boolean deleteOrder(String OrderId);

    boolean updateOrder(TimeOrder timeOrder);

}
