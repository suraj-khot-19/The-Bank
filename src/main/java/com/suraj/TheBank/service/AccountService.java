package com.suraj.TheBank.service;

import com.suraj.TheBank.dto.AccountDto;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;
import java.util.Objects;

public interface AccountService {
    AccountDto addNewAcc(AccountDto dto);

    AccountDto findMyAccount(long accountNumber);

    Map<String, Double> depositMoney(long accountNumber, double amount);

    Map<String, Object> withdrawMoney(long accountNumber, Double amount);
}
