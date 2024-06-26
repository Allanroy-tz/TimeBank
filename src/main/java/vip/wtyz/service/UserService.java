package vip.wtyz.service;

import vip.wtyz.pojo.User;
import vip.wtyz.pojo.UserInfo;

import java.util.List;

public interface UserService {
    User getUserById(String OpenId);

    List<User> getAllUsers();

    //TODO 返回值类型有待确认
    boolean insertUser(User user);

    boolean deleteUser(String OpenId);

    User userLogin(UserInfo userInfo);

    Integer getTimeCredit(String OpenId);

    Long getAllUserAmount();
}
