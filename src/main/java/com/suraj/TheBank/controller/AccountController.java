package com.suraj.TheBank.controller;

import com.suraj.TheBank.dto.AccountDto;
import com.suraj.TheBank.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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

    @PutMapping("/deposit/{accountNumber}")
    public ResponseEntity<String> deposit(@PathVariable(name = "accountNumber") long accountNumber, @RequestBody Map<String, Double> data) {
        /// @RequestBody double amount (we cannot do directly that)

        boolean isDeposited = service.depositMoney(accountNumber, data.get("amount"));

        if (isDeposited)
            return ResponseEntity.status(HttpStatus.OK).body("Amount Deposited successfully!");
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Your account is not associated with our bank");
    }
}
