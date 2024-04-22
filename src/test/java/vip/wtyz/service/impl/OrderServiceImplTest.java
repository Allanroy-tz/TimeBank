package vip.wtyz.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vip.wtyz.pojo.OrderList;
import vip.wtyz.service.OrderService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
    }

    @Test
    void deleteOrder() {
    }

    @Test
    void updateOrder() {
    }
}