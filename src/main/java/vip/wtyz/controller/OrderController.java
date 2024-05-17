package vip.wtyz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vip.wtyz.Utilities.ResultVO;
import vip.wtyz.pojo.TimeOrder;
import vip.wtyz.service.OrderService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("/addOrder")
    ResultVO AddOrder(@RequestBody TimeOrder timeOrder) {
        ResultVO resultVO = new ResultVO("200", null);
        if (!orderService.addOrder(timeOrder)) {
            resultVO.setCode("500");
            resultVO.setData("添加失败");
        }
        resultVO.setData("添加成功");
        System.out.println(timeOrder.toString());
        return resultVO;
    }

    @GetMapping("/getOrderList")
    ResultVO GetOrderList() {
        List<TimeOrder> allOrders = orderService.getAllOrders();
        ResultVO resultVO = new ResultVO("200", allOrders);
        return resultVO;
    }

    @GetMapping("/changeOrderState")
    ResultVO ChangeOrderState(@RequestParam Integer orderId, @RequestParam String state) {
        ResultVO resultVO = new ResultVO("200", "成功");
        if (!orderService.changeOrderState(orderId, state)) {
            resultVO.setData("失败");
            resultVO.setCode("201");
        }
        return resultVO;
    }

    @GetMapping("/getOrderByState")
    ResultVO GetOrderByState(@RequestParam String state) {
        List<TimeOrder> allOrderListByState = orderService.getAllOrderListByState(state);
        //        System.out.println(state);
        return new ResultVO("200", allOrderListByState);
    }

    @GetMapping("getAllOrderListForUser")
    ResultVO GetAllOrderListForUser(@RequestParam String OpenId) {
        ResultVO resultVO = new ResultVO("200", orderService.getAllOrderListForUser(OpenId));
        System.out.println(OpenId);
        return resultVO;
    }

    @GetMapping("getAllAcceptedOrderListForUser")
    ResultVO GetAllAcceptedOrderListForUser(@RequestParam String OpenId) {

        return new ResultVO("200", orderService.getAllAcceptedOrderListForUser(OpenId));
    }

    @GetMapping("getAllOrdersExceptUser")
    ResultVO GetAllOrdersExceptUser(@RequestParam String OpenId) {
        return new ResultVO("200", orderService.getAllOrdersExceptUser(OpenId));
    }

    @PostMapping("updateOrder")
    ResultVO UpdateOrder(@RequestBody TimeOrder timeOrder) {
        if (orderService.updateOrder(timeOrder))
            return new ResultVO("200", "更新成功");
        else return new ResultVO("201", "更新失败");
    }
}
