package vip.wtyz.service.impl;

import javafx.print.Printer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.wtyz.mapper.UserMapper;
import vip.wtyz.pojo.User;
import vip.wtyz.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

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
}
