package vip.wtyz.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@TableName("user")
public class User {
    @TableId(value = "OpenId")
    @JsonProperty(value = "OpenId")
    String OpenId;
    @TableField("UserName")
    @JsonProperty(value = "UserName")
    String UserName;
    @TableField("Phone")
    @JsonProperty(value = "Phone")
    String Phone;
    @TableField("AccountId")
    @JsonProperty(value = "AccountId")
    String AccountId;
    @TableField("AccountPassword")
    @JsonProperty(value = "AccountPassword")
    String AccountPassword;
    @TableField("TimeCredits")
    @JsonProperty(value = "TimeCredits")
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
