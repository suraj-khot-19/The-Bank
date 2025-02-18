package com.suraj.TheBank.controller;

import com.suraj.TheBank.dto.AccountDto;
import com.suraj.TheBank.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/thebank")
public class AccountController {

    // constructor injection
    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    /// create new account
    @PostMapping("/new")
    public ResponseEntity<AccountDto> addNewAcc(@RequestBody AccountDto dto) {
        return new ResponseEntity<>(service.addNewAcc(dto), HttpStatus.CREATED);
    }


    /// find account with account number
    @GetMapping("/find/{accountNumber}")
    public ResponseEntity<AccountDto> findMyAccount(@PathVariable(name = "accountNumber") long accountNumber) {
        AccountDto acc = service.findMyAccount(accountNumber);
        return ResponseEntity.ok(acc);
    }


    /// deposit money into account
    @PutMapping("/deposit/{accountNumber}")
    public ResponseEntity<?> deposit(@PathVariable(name = "accountNumber") long accountNumber, @RequestBody Map<String, Double> data) {
        /// @RequestBody double amount (we cannot do directly that)

        Map<String, Object> map = service.depositMoney(accountNumber, data.get("amount"));

        if (map.containsKey("error"))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
        else
            return ResponseEntity.ok(map);
    }

    /// withdraw a money
    @PutMapping("/withdraw/{accountNumber}")
    public ResponseEntity<?> withdraw(@PathVariable(name = "accountNumber") long accountNumber, @RequestBody Map<String, Double> data) {
        Map<String, Object> map = service.withdrawMoney(accountNumber, data.get("amount"));

        if (map.containsKey("error"))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
        else
            return ResponseEntity.ok(map);
    }

    /// get all accounts
    @GetMapping("/all")
    public ResponseEntity<List<AccountDto>> getAllAccounts() {
        return ResponseEntity.ok(service.getAllAccounts());
    }

    /// delete account
    @DeleteMapping("/delete/{accountNumber}")
    public ResponseEntity<Map<String, String>> deleteAccount(@PathVariable(name = "accountNumber") long accountNumber) {
        boolean isDeleted = service.deleteAccount(accountNumber);
        if (isDeleted) {
            return ResponseEntity.ok(Map.of("Message", "Account deleted with Number " + accountNumber));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("Error", "No Account found with Number " + accountNumber));
        }
    }
}
