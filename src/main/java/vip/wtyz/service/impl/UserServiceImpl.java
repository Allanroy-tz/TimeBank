package vip.wtyz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import vip.wtyz.Utilities.AppConfigInfo;
import vip.wtyz.mapper.UserMapper;
import vip.wtyz.pojo.User;
import vip.wtyz.pojo.UserInfo;
import vip.wtyz.service.UserService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Resource
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
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + AppConfigInfo.getAppid() + "&secret=" + AppConfigInfo.getSecret() + "&js_code=" + code + "&grant_type=authorization_code ";
        ResponseEntity<String> result = restTemplate.getForEntity(url, String.class);
        System.out.println(result.getBody());
        String s = result.getBody();
        int idx = s.indexOf("openid");
        idx += 8;
        int idx2 = idx;
        while (s.charAt(++idx2) != '"') ;
        String substring = s.substring(idx, idx2 + 1);
        System.out.println("substring = " + substring);
        return substring;
    }

    @Override
    public User userLogin(UserInfo userInfo) {
        String OpenId = fetchData(userInfo.getCode());
//        System.out.println(OpenData);
        System.out.println(userInfo.getCode());

        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        Long flag = userMapper.selectCount(queryWrapper.eq("OpenId", OpenId));
        if (flag == 0) {
            User user = new User(OpenId, userInfo.getName(), "18711857372", "222222222", "3333333333", 1000);
            userMapper.insert(user);
            return user;
        }
        return userMapper.selectById(OpenId);
    }

    @Override
    public Integer getTimeCredit(String OpenId) {
        User user = userMapper.selectById(OpenId);
        return user.getTimeCredits();
    }

    @Override
    public Long getAllUserAmount() {
        return userMapper.selectCount(null);
    }
}
