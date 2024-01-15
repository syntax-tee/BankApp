package com.bankapp.ogunladetaiye.service.transaction;

import com.bankapp.ogunladetaiye.exception.BadRequestException;
import com.bankapp.ogunladetaiye.utils.request.transaction.DepositRequest;
import com.bankapp.ogunladetaiye.utils.request.transaction.WithdrawalRequest;

public interface TransactionService {

    boolean withdrawFromUserAccount(WithdrawalRequest withdrawalRequest) throws BadRequestException;

    boolean depositToUserAccount(DepositRequest depositRequest) throws BadRequestException;
}
