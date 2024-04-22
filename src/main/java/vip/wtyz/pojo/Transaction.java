package vip.wtyz.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("transaction")
@Data
public class Transaction {
    @TableId(value = "TransactionId", type = IdType.AUTO)
    String TransactionId;
    @TableField("TransferorId")
    String TransferorId;

    public Transaction(String transferorId, String transfereeId, Integer transferAmount) {
        TransferorId = transferorId;
        TransfereeId = transfereeId;
        TransferAmount = transferAmount;
    }

    @TableField("TransfereeId")
    String TransfereeId;
    @TableField("TransferAmount")

    Integer TransferAmount;
}
