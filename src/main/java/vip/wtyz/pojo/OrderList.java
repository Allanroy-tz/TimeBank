package vip.wtyz.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class OrderList {
    //    发布者数据
    @TableId(value = "OrderId")
    Integer OrderId;
    String OpenId;
    String UserName;
    String Phone;
    //    接收者数据
    String AcceptUserName;
    String AcceptOpenId;
    String AcceptPhone;

    // 订单数据
    String Tittle;
    String Description;
    Integer TimeSpent;
    String Position;

    String DateTime;

    String OrderState;

}
