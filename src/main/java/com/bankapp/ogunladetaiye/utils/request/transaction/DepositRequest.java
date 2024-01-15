package com.bankapp.ogunladetaiye.utils.request.transaction;

public class DepositRequest extends TransactionRequest{

    private Double amount;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
