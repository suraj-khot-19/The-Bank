package com.suraj.TheBank.mapper;

import com.suraj.TheBank.dto.AccountDto;
import com.suraj.TheBank.model.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    /// entity to dto
    public AccountDto entityToDto(Account acc) {
        return new AccountDto(acc.getAccountNumber(),
                acc.getBalance(),
                acc.getName()
        );
        /// not sending email and phone number as they are not in constructor
    }

    /// dto to entity
    public Account dtoToEntity(AccountDto dto) {
        Account account = new Account();
        account.setAccountNumber(dto.getAccountNumber());
        account.setBalance(dto.getBalance());
        account.setName(dto.getName());
        account.setEmail(dto.getEmail());
        account.setPhone(dto.getPhone());

        return account;
    }
}
