package com.bankapp.ogunladetaiye.repository;

import com.bankapp.ogunladetaiye.db.BankAppDatabase;
import com.bankapp.ogunladetaiye.model.AccountStatement;
import com.bankapp.ogunladetaiye.model.UserAccount;
import com.bankapp.ogunladetaiye.utils.TransactionType;
import com.bankapp.ogunladetaiye.utils.request.transaction.DepositRequest;
import com.bankapp.ogunladetaiye.utils.request.transaction.WithdrawalRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TransactionRepository {

    @Autowired
    UserRepository repository;

  public  void withdrawFromUserAccount(WithdrawalRequest withdrawalRequest) {
        UserAccount userAccount = repository.getAccount(withdrawalRequest.getAccountNumber());
        userAccount.withdraw(withdrawalRequest.getWithDrawnAmount());

        AccountStatement accountStatement = new AccountStatement(new Date(),
                TransactionType.WITHDRAWAL.name(),
                "Withdrew " + withdrawalRequest.getWithDrawnAmount(),
                withdrawalRequest.getWithDrawnAmount(),
                userAccount.getBalance());
        userAccount.setAccountStatement(accountStatement);
        BankAppDatabase.accountStatementMap.put(userAccount.getAccountNumber(), accountStatement);
    }

   public void depositToUserAccount(DepositRequest depositRequest) {
        UserAccount userAccount = repository.getAccount(depositRequest.getAccountNumber());
        userAccount.deposit(depositRequest.getAmount());

        AccountStatement accountStatement = new AccountStatement(new Date(),
                TransactionType.DEPOSIT.name(),
                "Deposit " + depositRequest.getAmount(),
                depositRequest.getAmount(),
                userAccount.getBalance());
        userAccount.setAccountStatement(accountStatement);

        BankAppDatabase.accountStatementMap.put(userAccount.getAccountNumber(), accountStatement);
    }

    public UserAccount getAccount(String accountNumber){
        UserAccount account  = repository.getAccount(accountNumber);
        return account;
    }


}
