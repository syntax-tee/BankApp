package com.bankapp.ogunladetaiye.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountStatement {

    private Date transactionDate;
    private String transactionType;
    private String narration;
    private double amount;
    private double accountBalance;
}
