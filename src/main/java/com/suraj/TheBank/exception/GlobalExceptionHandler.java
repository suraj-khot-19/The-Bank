package com.suraj.TheBank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    /// handel all account related exception
    @ExceptionHandler(AccountException.class)
    public ResponseEntity<ErrorDetails> handelAccountException(AccountException exception, WebRequest webRequest) {
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                "ACCOUNT_NOT_FOUND",
                webRequest.getDescription(false)
        );

        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }


    /// handel generic exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Exception> handelGenericException(Exception exception, WebRequest webRequest) {
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                "INTERNAL_SERVER_ERROR",
                webRequest.getDescription(false)
        );

        return new ResponseEntity<>(exception, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /// minimum required balance in account
    @ExceptionHandler(MinBalanceException.class)
    public ResponseEntity<ErrorDetails> handelMinBalanceException(MinBalanceException minBalanceException, WebRequest webRequest) {
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                minBalanceException.getMessage(),
                "MIN_BALANCE_ERROR",
                webRequest.getDescription(false)
        );

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
}
