package model;

import java.util.List;
import java.util.UUID;

public class Transaction {
    List<OrderCommission> orderCommissionList;
    private UUID transactionId;
    private double totalAmountPaid;

    public Transaction(List<OrderCommission> orderCommissionList, UUID transactionId, double totalAmountPaid) {
        this.orderCommissionList = orderCommissionList;
        this.transactionId = transactionId;
        this.totalAmountPaid = totalAmountPaid;
    }

    public List<OrderCommission> getOrderCommissionList() {
        return orderCommissionList;
    }

    public void setOrderCommissionList(List<OrderCommission> orderCommissionList) {
        this.orderCommissionList = orderCommissionList;
    }

    public UUID getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(UUID transactionId) {
        this.transactionId = transactionId;
    }

    public double getTotalAmountPaid() {
        return totalAmountPaid;
    }

    public void setTotalAmountPaid(double totalAmountPaid) {
        this.totalAmountPaid = totalAmountPaid;
    }
}
