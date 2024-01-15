package com.bankapp.ogunladetaiye.utils.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiErrorResponse {
    private boolean status;
    private String message;
    private Object data;
    private int errorCode;
    private String error;

    public ApiErrorResponse(boolean status, String message, int errorCode) {
        this.status = status;
        this.message = message;
        this.errorCode = errorCode;
    }
}