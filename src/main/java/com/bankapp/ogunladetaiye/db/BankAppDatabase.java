package com.bankapp.ogunladetaiye.db;

import com.bankapp.ogunladetaiye.model.AccountStatement;
import com.bankapp.ogunladetaiye.model.UserAccount;

import java.util.HashMap;
import java.util.Map;

public class BankAppDatabase {

    public static Map<String, UserAccount> userAccountMap = new HashMap<>();
    public static Map<String, AccountStatement> accountStatementMap = new HashMap<>();


}
