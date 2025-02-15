package com.suraj.TheBank.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
    private long accountNumber;
    private double balance;
    private String name;
    private String email;
    private long phone;
}

