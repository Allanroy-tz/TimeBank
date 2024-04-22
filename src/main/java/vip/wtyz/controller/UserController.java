package vip.wtyz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import vip.wtyz.pojo.User;
import vip.wtyz.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    private RestTemplate restTemplate;

    public String fetchData(String code) {
        String url = "https://api.weixin.qq.com/sns/jscode2session";
        return restTemplate.getForObject(url, String.class);
    }

    @PostMapping("/login")
    User login(@RequestBody String code) {
        String OpenData = fetchData(code);
        User user = null;
        userService.insertUser(user);
        return null;
    }

}
