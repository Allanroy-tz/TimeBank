package vip.wtyz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import vip.wtyz.mapper.UserMapper;
import vip.wtyz.pojo.User;
import vip.wtyz.pojo.UserInfo;
import vip.wtyz.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public User getUserById(String OpenId) {
        User user;
        user = userMapper.selectById(OpenId);
        System.out.println(user);
        return user;
    }

    @Override
    public List<User> getAllUsers() {

        return userMapper.selectList(null);
    }

    @Override
    public boolean insertUser(User user) {
        return userMapper.insert(user) > 0;
    }

    @Override
    public boolean deleteUser(String OpenId) {

        return userMapper.deleteById(OpenId) > 0;
    }

    public String fetchData(String code) {
        String url = "https://api.weixin.qq.com/sns/jscode2session";
        return restTemplate.getForObject(url, String.class);
    }

    @Override
    public User userLogin(UserInfo userInfo) {
//        String OpenData = fetchData(code);
//        System.out.println(OpenData);
        System.out.println(userInfo.getCode());
        User user = new User("0000000", userInfo.getName(), "18711857372", "222222222", "3333333333", 1000);
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        Long flag = userMapper.selectCount(queryWrapper.eq("OpenId", user.getOpenId()));
        if (flag == 0)
            userMapper.insert(user);
        return user;
    }
}
