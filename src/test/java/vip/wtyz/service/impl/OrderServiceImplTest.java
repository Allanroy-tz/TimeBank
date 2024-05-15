package vip.wtyz.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vip.wtyz.pojo.OrderList;
import vip.wtyz.pojo.TimeOrder;
import vip.wtyz.service.OrderService;

import java.util.List;

@SpringBootTest
class OrderServiceImplTest {
    @Autowired
    OrderService orderService;

    @Test
    void getAllOrders() {
    }

    @Test
    void getAllOrdersExceptUser() {
    }

    @Test
    void getAllOrderListForUser() {

        String OpenId = "123123";
        List<OrderList> list = orderService.getAllOrderListForUser(OpenId);
        System.out.println(list.size());
    }

    @Test
    void getAllAcceptedOrderListForUser() {
        String OpenId = "123122";
        List<OrderList> list = orderService.getAllAcceptedOrderListForUser(OpenId);
        System.out.println(list.size());
    }

    @Test
    void addOrder() {
        TimeOrder timeOrder = new TimeOrder(null, "123321", "ooo", null, "2222", 100, "---------", "2024-10-20 10:20", "-2");
        System.out.println(orderService.addOrder(timeOrder));
    }

    @Test
    void deleteOrder() {
    }

    @Test
    void updateOrder() {
    }
}