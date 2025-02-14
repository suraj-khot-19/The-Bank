package com.suraj.TheBank.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AccountDto {
    private long accountNumber;

    private double balance;
    private String name;
    private String email;
    private long phone;

    /// not added email and phone
    public AccountDto(long accountNumber, double balance, String name) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.name = name;
    }
}

