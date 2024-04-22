package vip.wtyz.service;

import vip.wtyz.pojo.User;

import java.util.List;

public interface UserService {
    User getUserById(String OpenId);

    List<User> getAllUsers();

    //TODO 返回值类型有待确认
    boolean insertUser(User user);

    boolean deleteUser(String OpenId);
}
