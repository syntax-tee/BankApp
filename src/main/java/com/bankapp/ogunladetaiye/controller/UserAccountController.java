package com.bankapp.ogunladetaiye.controller;

import com.bankapp.ogunladetaiye.exception.BadRequestException;
import com.bankapp.ogunladetaiye.model.AccountStatement;
import com.bankapp.ogunladetaiye.model.UserAccount;
import com.bankapp.ogunladetaiye.service.user.UserAccountService;
import com.bankapp.ogunladetaiye.utils.request.useraccount.NewUserRequest;
import com.bankapp.ogunladetaiye.utils.request.useraccount.UserRequest;
import com.bankapp.ogunladetaiye.utils.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class UserAccountController {

    @Autowired
    UserAccountService userAccountService;

    @PostMapping("/create_account")
    private ResponseEntity<ApiResponse> createAccount(@RequestBody NewUserRequest request) throws BadRequestException {
        userAccountService.createUserAccount(request);
        ApiResponse response = new ApiResponse(HttpStatus.OK.value(),true, "UserAccount Created Successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/account_info")
    private ResponseEntity<ApiResponse> getAccountInformation(@RequestBody UserRequest userRequest) throws BadRequestException {
        UserAccount userAccount = userAccountService.fetchUserAccountInfo(userRequest);
        ApiResponse response = new ApiResponse(HttpStatus.OK.value(),true, "Account Information Retrieved Successfully",userAccount);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/account_statement")
    private ResponseEntity<ApiResponse> fetchAccountStatement(@RequestBody UserRequest userRequest) throws BadRequestException {
        AccountStatement accountStatement = userAccountService.fetchAccountStatement(userRequest);
        ApiResponse response = new ApiResponse(HttpStatus.OK.value(),true, "Account Statement Retrieved Successfully",accountStatement);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
