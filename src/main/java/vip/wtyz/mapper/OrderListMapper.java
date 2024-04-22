package vip.wtyz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import vip.wtyz.pojo.OrderList;

import java.util.List;

@Mapper
public interface OrderListMapper {
    @Select("SELECT o.OrderId,u.OpenId,u.UserName,u.Phone,u1.UserName as AcceptUserName,u1.OpenId as AcceptOpenId,u1.Phone as AcceptPhone,o.Tittle,o.Description,o.TimeSpent,o.Position,o.DateTime,o.OrderState FROM timeorder o inner join user u on o.OpenId=u.OpenId inner join user u1 on o.AcceptOpenId=u1.OpenId where o.OpenId=#{OpenId}")
    List<OrderList> GetAllOrderListByOpenId(@Param("OpenId") String OpenId);

    @Select("SELECT o.OrderId,u.OpenId,u.UserName,u.Phone,u1.UserName as AcceptUserName,u1.OpenId as AcceptOpenId,u1.Phone as AcceptPhone,o.Tittle,o.Description,o.TimeSpent,o.Position,o.DateTime,o.OrderState FROM timeorder o inner join user u on o.OpenId=u.OpenId inner join user u1 on o.AcceptOpenId=u1.OpenId where o.AcceptOpenId=#{OpenId}")
    List<OrderList> GetAllOrderListByAcceptOpenId(@Param("OpenId") String OpenId);
}
