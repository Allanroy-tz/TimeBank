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
    /**
     * 转让者
     */
    @TableField("TransferorId")
    @JsonProperty(value = "TransferorId")
    String TransferorId;

    public Transaction(Integer transactionId, String transferorId, String transfereeId, Integer orderId, Integer transferAmount) {
        TransactionId = transactionId;
        TransferorId = transferorId;
        TransfereeId = transfereeId;
        OrderId = orderId;
        TransferAmount = transferAmount;
    }

    /**
     * 被转让者
     */
    @TableField("TransfereeId")
    @JsonProperty(value = "TransfereeId")
    String TransfereeId;


    @TableField("OrderId")
    @JsonProperty(value = "OrderId")
    Integer OrderId;
    @TableField("TransferAmount")
    @JsonProperty(value = "TransferAmount")
    /**
     * 转账时间额度
     */
            Integer TransferAmount;
}
