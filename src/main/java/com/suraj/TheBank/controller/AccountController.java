package com.suraj.TheBank.controller;

import com.suraj.TheBank.dto.AccountDto;
import com.suraj.TheBank.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<?> findMyAccount(@PathVariable(name = "accountNumber") long accountNumber) {
        AccountDto acc = service.findMyAccount(accountNumber);
        if (acc != null) {
            return ResponseEntity.ok(acc);
        } else {
            Map<String, String> map = Map.of("message", "Account not found with number" + accountNumber);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
        }
    }


    /// deposit money into account
    @PutMapping("/deposit/{accountNumber}")
    public ResponseEntity<?> deposit(@PathVariable(name = "accountNumber") long accountNumber, @RequestBody Map<String, Double> data) {
        /// @RequestBody double amount (we cannot do directly that)

        Map<String, Double> map = service.depositMoney(accountNumber, data.get("amount"));

        if (!map.isEmpty())
            return ResponseEntity.ok(map);
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", "Your account is not associated with our bank"));
        }
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

}
