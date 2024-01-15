package com.bankapp.ogunladetaiye.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserAccount {

    private String accountNumber;
    private String accountPassword;
    private String accountName;
    private Double balance = 0.0;
    AccountStatement accountStatement;

    public UserAccount(String accountName,  String accountPassword, String accountNumber) {
        this.accountName = accountName;
        this.accountPassword = accountPassword;
        this.accountNumber = accountNumber;
    }

    public void deposit(double amountIn) {
        balance = balance + amountIn;
    }

    public boolean withdraw(double amountIn) {
        if (amountIn > balance) {
            return false;
        } else {
            balance = balance - amountIn;
            return true;
        }
    }
}
