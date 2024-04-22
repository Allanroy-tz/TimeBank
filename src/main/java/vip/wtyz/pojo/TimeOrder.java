package vip.wtyz.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


@Data
@TableName("timeorder")
public class TimeOrder {
    @TableId(value = "OrderId")
    Integer OrderId;
    @TableField("OpenId")
    String OpenId;
    @TableField("Tittle")
    String Tittle;
    @TableField("AcceptOpenId")
    String AcceptOpenId;
    @TableField("Description")
    String Description;
    @TableField("TimeSpent")
    Integer TimeSpent;
    @TableField("Position")
    String Position;
    //TODO DateTime
    @TableField("DateTime")
    String DateTime;
    @TableField("OrderState")
    String OrderState;

    public TimeOrder(Integer orderId, String openId, String tittle, String acceptOpenId, String description, Integer timeSpent, String position, String dateTime, String orderState) {
        OrderId = orderId;
        OpenId = openId;
        Tittle = tittle;
        AcceptOpenId = acceptOpenId;
        Description = description;
        TimeSpent = timeSpent;
        Position = position;
        DateTime = dateTime;
        OrderState = orderState;
    }
}
