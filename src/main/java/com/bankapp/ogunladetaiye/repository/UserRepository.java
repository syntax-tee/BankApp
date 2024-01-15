package com.bankapp.ogunladetaiye.repository;


import com.bankapp.ogunladetaiye.db.BankAppDatabase;
import com.bankapp.ogunladetaiye.model.AccountStatement;
import com.bankapp.ogunladetaiye.model.UserAccount;
import com.bankapp.ogunladetaiye.utils.Util;
import com.bankapp.ogunladetaiye.utils.request.useraccount.NewUserRequest;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class UserRepository {

    public UserAccount createAccount(NewUserRequest request) {
        String accountNumber = Util.getAccountNumber();
        System.out.println("Account number " + accountNumber);
        UserAccount userAccount = new UserAccount(request.getAccountName(), request.getAccountPassword(), accountNumber);
        BankAppDatabase.userAccountMap.put(userAccount.getAccountNumber(), userAccount);
        return userAccount;
    }

    public UserAccount getAccount(String accountNumber) {
        UserAccount account = BankAppDatabase.userAccountMap.get(accountNumber);
        Collection<UserAccount> accounts = BankAppDatabase.userAccountMap.values();
        System.out.println("Accounts " + accounts);
        return account;
    }

    public AccountStatement getAccountStatement(String accountNumber) {
        UserAccount account = getAccount(accountNumber);
        return account.getAccountStatement();
    }


    public boolean getAccountByAccountName(String name) {
        Collection<UserAccount> accounts = BankAppDatabase.userAccountMap.values();
        for (UserAccount userAccount : accounts) {
            if (userAccount.getAccountName().equals(name)) {
                return true;
            }
        }
        return false;
    }

}
