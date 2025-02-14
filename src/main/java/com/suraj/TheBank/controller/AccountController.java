package com.suraj.TheBank.controller;

import com.suraj.TheBank.dto.AccountDto;
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
    public ResponseEntity<AccountDto> addNewAcc(@RequestBody AccountDto dto) {
        return new ResponseEntity<>(service.addNewAcc(dto), HttpStatus.CREATED);
    }
}
