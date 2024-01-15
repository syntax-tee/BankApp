package com.bankapp.ogunladetaiye.utils.request.transaction;

public class WithdrawalRequest extends TransactionRequest {
    private String accountPassword;
    private Double withDrawnAmount;

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    public Double getWithDrawnAmount() {
        return withDrawnAmount;
    }

    public void setWithDrawnAmount(Double withDrawnAmount) {
        this.withDrawnAmount = withDrawnAmount;
    }
}
