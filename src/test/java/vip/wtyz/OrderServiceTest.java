package vip.wtyz;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vip.wtyz.mapper.OrderMapper;
import vip.wtyz.pojo.TimeOrder;
import vip.wtyz.service.OrderService;

@SpringBootTest
public class OrderServiceTest {
    @Autowired
    OrderService orderService;
    @Autowired
    OrderMapper orderMapper;

    @Test
    void AddOrderTest() {
        TimeOrder timeOrder = new TimeOrder(null, "123123", "2222", "12222", "1222", 2222, "222222", "2024-02-02", "1");
        System.out.println(timeOrder);
        System.out.println(orderMapper.insert(timeOrder));
    }
}
