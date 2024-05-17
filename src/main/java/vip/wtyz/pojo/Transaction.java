package vip.wtyz.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@TableName("transaction")
@Data
public class Transaction {
    @TableId(value = "TransactionId", type = IdType.AUTO)
    Integer TransactionId;
    @TableField("TransferorId")
    @JsonProperty(value = "TransferorId")
    String TransferorId;

    public Transaction(String transferorId, String transfereeId, Integer transferAmount) {
        TransferorId = transferorId;
        TransfereeId = transfereeId;
        TransferAmount = transferAmount;
    }

    @TableField("TransfereeId")
    @JsonProperty(value = "TransfereeId")
    String TransfereeId;
    @TableField("TransferAmount")
    @JsonProperty(value = "TransferAmount")

    Integer TransferAmount;
}
