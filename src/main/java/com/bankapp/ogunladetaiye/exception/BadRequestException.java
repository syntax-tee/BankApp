package com.bankapp.ogunladetaiye.exception;

import java.io.IOException;

public class BadRequestException extends IOException {
    private String message;


    public BadRequestException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
