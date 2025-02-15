package com.suraj.TheBank.service;

import com.suraj.TheBank.dto.AccountDto;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

public interface AccountService {
    AccountDto addNewAcc(AccountDto dto);

    AccountDto findMyAccount(long accountNumber);

    Map<String,Double> depositMoney(long accountNumber, double amount);

}
