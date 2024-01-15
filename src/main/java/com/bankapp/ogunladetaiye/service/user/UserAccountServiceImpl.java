package com.bankapp.ogunladetaiye.service.user;

import com.bankapp.ogunladetaiye.exception.BadRequestException;
import com.bankapp.ogunladetaiye.model.AccountStatement;
import com.bankapp.ogunladetaiye.model.UserAccount;
import com.bankapp.ogunladetaiye.repository.UserRepository;
import com.bankapp.ogunladetaiye.utils.request.useraccount.NewUserRequest;
import com.bankapp.ogunladetaiye.utils.request.useraccount.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    UserRepository repository;

    @Override
    public UserAccount createUserAccount(NewUserRequest request) throws BadRequestException {
          if (repository.getAccountByAccountName(request.getAccountName())){
              throw  new BadRequestException("Account name already exit");
          }
        return repository.createAccount(request);
    }

    @Override
    public UserAccount fetchUserAccountInfo(UserRequest request) throws BadRequestException {
        UserAccount account = repository.getAccount(request.getAccountNumber());
        if (account != null && !account.getAccountPassword().equals(request.getAccountPassword())) {
            throw new BadRequestException("Invalid User Detail");
        }
        return account;
    }

    @Override
    public AccountStatement fetchAccountStatement(UserRequest request) throws BadRequestException {
        return repository.getAccountStatement(request.getAccountNumber());
    }

}
