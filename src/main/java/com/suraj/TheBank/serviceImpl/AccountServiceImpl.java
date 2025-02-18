package com.suraj.TheBank.serviceImpl;

import com.suraj.TheBank.dto.AccountDto;
import com.suraj.TheBank.exception.AccountException;
import com.suraj.TheBank.mapper.AccountMapper;
import com.suraj.TheBank.model.Account;
import com.suraj.TheBank.repository.AccountRepository;
import com.suraj.TheBank.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AccountServiceImpl implements AccountService {

    // constructor injection
    private final AccountRepository repo;
    private final AccountMapper mapper;

    public AccountServiceImpl(AccountRepository repo, AccountMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }



    /// create new account
    @Override
    public AccountDto addNewAcc(AccountDto dto) {
        Account acc = mapper.dtoToEntity(dto);    // converting to dto
        Account save = repo.save(acc);            // saving entity
        return mapper.entityToDto(save);        // sending dto
    }



    /// find account by id
    @Override
    public AccountDto findMyAccount(long accountNumber) {
        Account acc = repo.findById(accountNumber).orElseThrow(() -> new AccountException("Your account is not associated with our bank"));

        return mapper.entityToDto(acc);
    }



    /// deposit money into an account
    @Override
    public Map<String, Object> depositMoney(long accountNumber, double amount) {
        Account account = repo.findById(accountNumber).orElseThrow(() -> new AccountException("Your account is not associated with our bank"));

        Map<String, Object> map = new HashMap<>();

        double prev = account.getBalance();
        double total = prev + amount;
        account.setBalance(total);
        repo.save(account);

        map.put("Message", "Dear " + account.getName() + " Rs " + amount + " credited to your account. Available balance RS " + total);

        return map;
    }



    /// withdraw money from an account
    @Override
    public Map<String, Object> withdrawMoney(long accountNumber, Double amount) {
        /// find account
        Account account = repo.findById(accountNumber).orElseThrow(() -> new AccountException("Your account is not associated with our bank"));

        Map<String, Object> map = new HashMap<>();

        double prev = account.getBalance();
        double total = prev - amount;

        /// minimum 500 balance should be there
        if (prev - 500 >= amount) {
            account.setBalance(total);
            repo.save(account);

            map.put("Message", "Dear " + account.getName() + " Rs " + amount + " debited from your account. Available balance RS " + total);
        } else {
            map.put("Message", "Dear " + account.getName() + " Available balance RS " + prev + ", Max Withdrawal RS " + (prev - 500));
        }
        return map;
    }



    /// get all accounts
    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = repo.findAll();

        return accounts.stream().map(mapper::entityToDto).toList();
    }



    /// delete an account
    @Override
    public boolean deleteAccount(long accountNumber) {
        repo.findById(accountNumber).orElseThrow(() -> new AccountException("Your account is not associated with our bank"));

        repo.deleteById(accountNumber);
        return true;
    }
}
