package com.suraj.TheBank.service;

import com.suraj.TheBank.dto.AccountDto;
import org.springframework.web.bind.annotation.RequestBody;

public interface AccountService {
    AccountDto addNewAcc(AccountDto dto);

    AccountDto findMyAccount(long accountNumber);

    boolean depositMoney(long accountNumber, double amount);

}
