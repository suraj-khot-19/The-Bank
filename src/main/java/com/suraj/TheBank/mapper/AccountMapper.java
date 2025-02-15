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
                acc.getName(),
                acc.getEmail(),
                acc.getPhone()
        );
    }

    /// dto to entity
    public Account dtoToEntity(AccountDto dto) {
        return new Account(dto.getAccountNumber(),
                dto.getBalance(),
                dto.getName(),
                dto.getEmail(),
                dto.getPhone()
        );
    }
}
