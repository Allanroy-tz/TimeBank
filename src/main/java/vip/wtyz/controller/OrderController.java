package vip.wtyz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vip.wtyz.Utilities.ResultVO;
import vip.wtyz.pojo.TimeOrder;
import vip.wtyz.service.OrderService;

@CrossOrigin
@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("/addOrder")
    ResultVO AddOrder(TimeOrder timeOrder) {
        ResultVO resultVO = new ResultVO("200", null);
        if (!orderService.addOrder(timeOrder))

            resultVO.setCode("500");
        return resultVO;
    }
}
