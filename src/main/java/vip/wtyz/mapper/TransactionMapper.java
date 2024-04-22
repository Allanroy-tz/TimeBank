package vip.wtyz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import vip.wtyz.pojo.Transaction;

@Mapper
@Repository
public interface TransactionMapper extends BaseMapper<Transaction> {
}
