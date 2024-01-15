package com.bankapp.ogunladetaiye.service.transaction;

import com.bankapp.ogunladetaiye.exception.BadRequestException;
import com.bankapp.ogunladetaiye.model.UserAccount;
import com.bankapp.ogunladetaiye.repository.TransactionRepository;
import com.bankapp.ogunladetaiye.utils.request.transaction.DepositRequest;
import com.bankapp.ogunladetaiye.utils.request.transaction.WithdrawalRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public boolean withdrawFromUserAccount(WithdrawalRequest withdrawalRequest) throws BadRequestException {
        UserAccount account = transactionRepository.getAccount(withdrawalRequest.getAccountNumber());

        if (account != null && !account.getAccountPassword().equals(withdrawalRequest.getAccountPassword())) {
            throw new BadRequestException("Invalid User Detail");
        }
        if (account.getBalance() >= 500) {
            transactionRepository.withdrawFromUserAccount(withdrawalRequest);
          return true;
        }else{
            throw new BadRequestException("Amount can not be lower than #" + withdrawalRequest.getWithDrawnAmount());
        }
    }

    @Override
    public boolean depositToUserAccount(DepositRequest depositRequest) throws BadRequestException {
        UserAccount account = transactionRepository.getAccount(depositRequest.getAccountNumber());
        if (account == null) {
            throw new BadRequestException("Invalid User Detail");
        }
        if (depositRequest.getAmount() > 1 || depositRequest.getAmount() < 1000000) {
            transactionRepository.depositToUserAccount(depositRequest);
            return true;
        } else {
            throw new BadRequestException("Deposit Amount can not be lower  than #1 or greater than #1000000" + depositRequest.getAmount());
        }
    }
}
