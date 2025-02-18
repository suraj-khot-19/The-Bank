package com.suraj.TheBank.controller;

import com.suraj.TheBank.dto.AccountDto;
import com.suraj.TheBank.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
        /// @RequestBody double amount (we cannot do directly read that)

        return ResponseEntity.ok(service.depositMoney(accountNumber, data.get("amount")));
    }

    /// withdraw a money
    @PutMapping("/withdraw/{accountNumber}")
    public ResponseEntity<?> withdraw(@PathVariable(name = "accountNumber") long accountNumber, @RequestBody Map<String, Double> data) {
        return ResponseEntity.ok(service.withdrawMoney(accountNumber, data.get("amount")));
    }

    /// get all accounts
    @GetMapping("/all")
    public ResponseEntity<List<AccountDto>> getAllAccounts() {
        return ResponseEntity.ok(service.getAllAccounts());
    }

    /// delete account
    @DeleteMapping("/delete/{accountNumber}")
    public ResponseEntity<Map<String, String> > deleteAccount(@PathVariable(name = "accountNumber") long accountNumber) {
        return ResponseEntity.ok(service.deleteAccount(accountNumber));
    }
}
