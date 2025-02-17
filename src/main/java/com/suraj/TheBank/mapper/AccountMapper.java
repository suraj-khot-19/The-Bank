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
        /*
        simple java impl

            return new Account(dto.getAccountNumber(),
                    dto.getBalance(),
                    dto.getName(),
                    dto.getEmail(),
                    dto.getPhone()
            );
        */

        /// using record class from java17+
        return new Account(
                dto.accountNumber(),
                dto.balance(),
                dto.name(),
                dto.email(),
                dto.phone()
        );
    }
}
