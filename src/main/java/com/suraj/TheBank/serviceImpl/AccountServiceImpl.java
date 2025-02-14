package com.suraj.TheBank.serviceImpl;

import com.suraj.TheBank.model.Account;
import com.suraj.TheBank.repository.AccountRepository;
import com.suraj.TheBank.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    // constructor injection
    private final AccountRepository repo;

    public AccountServiceImpl(AccountRepository repo) {
        this.repo = repo;
    }

    @Override
    public Account addNewAcc(Account acc) {
        return repo.save(acc);
    }
}
