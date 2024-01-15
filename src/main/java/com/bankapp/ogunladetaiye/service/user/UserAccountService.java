package com.bankapp.ogunladetaiye.service.user;

import com.bankapp.ogunladetaiye.exception.BadRequestException;
import com.bankapp.ogunladetaiye.model.AccountStatement;
import com.bankapp.ogunladetaiye.model.UserAccount;
import com.bankapp.ogunladetaiye.utils.request.useraccount.NewUserRequest;
import com.bankapp.ogunladetaiye.utils.request.useraccount.UserRequest;
import org.springframework.stereotype.Service;

@Service
public interface UserAccountService {

    UserAccount createUserAccount(NewUserRequest newUserRequest) throws BadRequestException;

    UserAccount fetchUserAccountInfo(UserRequest request) throws BadRequestException;

    AccountStatement fetchAccountStatement(UserRequest request) throws BadRequestException;


}
