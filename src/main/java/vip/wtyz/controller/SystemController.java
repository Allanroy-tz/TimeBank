package vip.wtyz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.wtyz.Utilities.ResultVO;
import vip.wtyz.pojo.SysDataInfo;
import vip.wtyz.service.OrderService;
import vip.wtyz.service.TransactionService;
import vip.wtyz.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("sys")
public class SystemController {
    @Autowired
    OrderService orderService;
    @Autowired
    UserService userService;
    @Autowired
    TransactionService transactionService;

    @GetMapping("getAllDataAmount")
    ResultVO getAllDataAmount() {
        SysDataInfo sysDataInfo = new SysDataInfo(orderService.getAllOrderAmount(), userService.getAllUserAmount(), transactionService.getAllTransactionAmount(), (long) orderService.getAllOrderListByState("-1").size());
        return new ResultVO("200", sysDataInfo);
    }
}
