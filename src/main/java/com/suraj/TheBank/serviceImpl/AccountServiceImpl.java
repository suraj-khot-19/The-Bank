package com.suraj.TheBank.serviceImpl;

import com.suraj.TheBank.dto.AccountDto;
import com.suraj.TheBank.mapper.AccountMapper;
import com.suraj.TheBank.model.Account;
import com.suraj.TheBank.repository.AccountRepository;
import com.suraj.TheBank.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    // constructor injection
    private final AccountRepository repo;
    private final AccountMapper mapper;

    public AccountServiceImpl(AccountRepository repo, AccountMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public AccountDto addNewAcc(AccountDto dto) {
        Account acc = mapper.dtoToEntity(dto);    // converting to dto
        Account save = repo.save(acc);            // saving entity
        return mapper.entityToDto(save);        // sending dto
    }

    @Override
    public AccountDto findMyAccount(long accountNumber) {
        Account acc = repo.findById(accountNumber).orElse(null);
        if (acc != null)
            return mapper.entityToDto(acc);
        else return null;
    }

    @Override
    public Map<String, Object> depositMoney(long accountNumber, double amount) {
        Account account = repo.findById(accountNumber).orElse(null);

        Map<String, Object> map = new HashMap<>();

        if (account != null) {
            double prev = account.getBalance();
            double total = prev + amount;
            account.setBalance(total);
            repo.save(account);

            map.put("Message", "Dear " + account.getName() + " Rs " + amount + " credited to your account. Available balance RS " + total);
        } else {
            map.put("error","Your account is not associated with our bank");
        }
        return map;
    }

    @Override
    public Map<String, Object> withdrawMoney(long accountNumber, Double amount) {
        Account account = repo.findById(accountNumber).orElse(null);
        Map<String, Object> map = new HashMap<>();

        if (account != null) {
            double prev = account.getBalance();
            double total = prev - amount;

            /// minimum 500 baleen should be there
            if (prev - 500 >= amount) {
                account.setBalance(total);
                repo.save(account);

                map.put("Message", "Dear " + account.getName() + " Rs " + amount + " debited from your account. Available balance RS " + total);
            } else {
                map.put("Message", "Dear " + account.getName() + " Available balance RS " + prev + ", Max Withdrawal RS " + (prev - 500));
            }
            return map;
        } else {
            map.put("error", "Your account is not associated with our bank");
            return map;
        }

    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = repo.findAll();

        return accounts.stream().map(mapper::entityToDto).toList();
    }

}
