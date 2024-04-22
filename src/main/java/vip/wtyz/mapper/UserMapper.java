package vip.wtyz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import vip.wtyz.pojo.User;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {
}
