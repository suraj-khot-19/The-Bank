package com.suraj.TheBank.controller;

import com.suraj.TheBank.model.Account;
import com.suraj.TheBank.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/thebank")
public class AccountController {

    // constructor injection
    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    @PostMapping("/new")
    public ResponseEntity<Account> addNewAcc(@RequestBody Account acc) {
        return new ResponseEntity<>(service.addNewAcc(acc), HttpStatus.OK);
    }
}
