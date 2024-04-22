package vip.wtyz.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user")
public class User {
    @TableId(value = "OpenId")
    String OpenId;
    @TableField("UserName")
    String UserName;
    @TableField("Phone")
    String Phone;
    @TableField("AccountId")
    String AccountId;
    @TableField("AccountPassword")
    String AccountPassword;
    @TableField("TimeCredits")
    Integer TimeCredits;

    public User(String openId, String userName, String phone, String accountId, String accountPassword, Integer timeCredits) {
        this.OpenId = openId;
        this.UserName = userName;
        this.Phone = phone;
        this.AccountId = accountId;
        this.AccountPassword = accountPassword;
        this.TimeCredits = timeCredits;
    }
}
