package com.coderscampus.mapping;

import java.time.LocalDate;

public class BankTransaction {
    private Integer transactionId; 
    private LocalDate createdDate;
    private Double amount;

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "BankTransaction [transactionId=" + transactionId + ", createdDate=" + createdDate + ", amount=" + amount
                + "]";
    }
}
