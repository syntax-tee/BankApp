package com.bankapp.ogunladetaiye.exception;


import com.bankapp.ogunladetaiye.utils.response.ApiErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiErrorResponse> handleBadRequestException(Exception ex) {
        ApiErrorResponse error = new ApiErrorResponse();
        error.setMessage(ex.getMessage());
        error.setData(null);
        error.setStatus(false);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    public ResponseEntity<ApiErrorResponse> handleNotFoundException(Exception ex) {
        ApiErrorResponse error = new ApiErrorResponse();
        error.setMessage(ex.getMessage());
        error.setData(null);
        error.setStatus(false);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
