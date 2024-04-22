package vip.wtyz;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vip.wtyz.mapper.UserMapper;
import vip.wtyz.pojo.User;
import vip.wtyz.service.UserService;

@SpringBootTest
class UserServiceTest {

    @Autowired
    UserMapper userMapper;

    @Test
    void TestInsertUserMapper() {
        System.out.println(("----- Insert User test ------"));
        User user = new User(null, "testName", "18711857372", "2222222222222222222", "222233333333333333", 2000);
        System.out.println(userMapper.insert(user));
//        List<UserPassword> userList = userPasswordMapper.selectList(null);
//        for(UserPassword user:userList) {
//            System.out.println(user);
//        }
    }

    @Test
    void TestGetUserMapper() {
        System.out.println(("----- Get User test ------"));
        System.out.println(userMapper.selectList(null));
    }

    @Autowired
    UserService userService;

    @Test
    void TestGetUserByIdService() {
        userService.getUserById("999");
    }

    @Test
    void TestDeleteUserByIdService() {
        userService.deleteUser("999");
    }
}
