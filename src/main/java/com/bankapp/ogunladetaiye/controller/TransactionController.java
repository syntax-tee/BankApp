package com.bankapp.ogunladetaiye.controller;

import com.bankapp.ogunladetaiye.exception.BadRequestException;
import com.bankapp.ogunladetaiye.service.transaction.TransactionService;
import com.bankapp.ogunladetaiye.utils.request.transaction.DepositRequest;
import com.bankapp.ogunladetaiye.utils.request.transaction.WithdrawalRequest;
import com.bankapp.ogunladetaiye.utils.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class TransactionController {


    @Autowired
    TransactionService transactionService;

    @PostMapping("/deposit")
    private ResponseEntity<ApiResponse> depositFundToUserAccount(@RequestBody DepositRequest request) throws BadRequestException {
        ApiResponse response;
        if (transactionService.depositToUserAccount(request)) {
            response = new ApiResponse(HttpStatus.OK.value(), true, "Deposit of #"+request.getAmount()+" was Successful");
        } else {
            throw new BadRequestException("Invalid input");
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/withdrawal")
    private ApiResponse withdrawFromUserAccount(@RequestBody WithdrawalRequest request) throws BadRequestException {
        ApiResponse response;
        if (transactionService.withdrawFromUserAccount(request)) {
            response = new ApiResponse(HttpStatus.OK.value(), true, "Withdrawal of #"+request.getWithDrawnAmount()+" was Successful");
        } else {
            throw new BadRequestException("Invalid input");
        }
        return response;
    }


}
