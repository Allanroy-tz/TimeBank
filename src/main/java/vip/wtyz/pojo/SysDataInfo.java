package vip.wtyz.pojo;

import lombok.Data;

@Data
public class SysDataInfo {
    Long OrderAmount;
    Long UserAmount;
    Long TransactionAmount;

    public SysDataInfo(Long orderAmount, Long userAmount, Long transactionAmount, Long unapprovedOrdersAmount) {
        OrderAmount = orderAmount;
        UserAmount = userAmount;
        TransactionAmount = transactionAmount;
        UnapprovedOrdersAmount = unapprovedOrdersAmount;
    }

    Long UnapprovedOrdersAmount;
}
