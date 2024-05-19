package vip.wtyz.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
@TableName("timeorder")
public class TimeOrder {
    @TableId(value = "OrderId", type = IdType.AUTO)
    @JsonProperty(value = "OrderId")
    Integer OrderId;
    @TableField("OpenId")
    @JsonProperty("OpenId")
    String OpenId;
    @TableField("Tittle")
    @JsonProperty("Tittle")
    String Tittle;
    @TableField("AcceptOpenId")
    @JsonProperty("AcceptOpenId")
    String AcceptOpenId;
    @TableField("Description")
    @JsonProperty("Description")
    String Description;
    @TableField("TimeSpent")
    @JsonProperty("TimeSpent")
    Integer TimeSpent;
    @TableField("Position")
    @JsonProperty("Position")
    String Position;
    //TODO DateTime
    @TableField("DateTime")
    @JsonProperty("DateTime")
    String DateTime;
    /**
     * -3：已取消
     * -2：审核未通过
     * -1：待审核
     * 0：待接单
     * 1：已接单
     * 2：已完成
     * <p>
     * 1 2
     */
    @TableField("OrderState")
    @JsonProperty("OrderState")
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

    public TimeOrder() {

    }
}
