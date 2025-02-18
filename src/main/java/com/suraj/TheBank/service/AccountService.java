package com.suraj.TheBank.service;

import com.suraj.TheBank.dto.AccountDto;

import java.util.List;
import java.util.Map;

public interface AccountService {
    AccountDto addNewAcc(AccountDto dto);

    AccountDto findMyAccount(long accountNumber);

    Map<String, String> depositMoney(long accountNumber, double amount);

    Map<String, String> withdrawMoney(long accountNumber, Double amount);

    List<AccountDto> getAllAccounts();

    Map<String, String> deleteAccount(long accountNumber);
}
