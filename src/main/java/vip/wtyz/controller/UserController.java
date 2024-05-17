package vip.wtyz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vip.wtyz.Utilities.ResultVO;
import vip.wtyz.pojo.User;
import vip.wtyz.pojo.UserInfo;
import vip.wtyz.service.UserService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;


    @PostMapping("/login")
    ResultVO Login(@RequestBody UserInfo userInfo) {
        User user = userService.userLogin(userInfo);
        System.out.println(user);
        return new ResultVO("200", user);
    }

    @GetMapping("/getUserById")
    ResultVO GetUserById(@RequestParam String OpenId) {
        User user = userService.getUserById(OpenId);
        return new ResultVO("200", user);
    }

    @GetMapping("/getAllUsers")
    ResultVO GetAllUsers() {
        List<User> allUsers = userService.getAllUsers();
        return new ResultVO("200", allUsers);
    }

    @PostMapping("/insertUser")
    ResultVO InsertUser(@RequestBody User user) {
        boolean flag = userService.insertUser(user);
        return new ResultVO(flag ? "200" : "201", flag ? "添加成功" : "添加失败");
    }
}
