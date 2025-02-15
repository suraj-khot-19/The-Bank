package com.suraj.TheBank.serviceImpl;

import com.suraj.TheBank.dto.AccountDto;
import com.suraj.TheBank.mapper.AccountMapper;
import com.suraj.TheBank.model.Account;
import com.suraj.TheBank.repository.AccountRepository;
import com.suraj.TheBank.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

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
    public Map<String, Double> depositMoney(long accountNumber, double amount) {
        Account acc = repo.findById(accountNumber).orElse(null);

        Map<String, Double> map = new HashMap<>();

        if (acc != null) {
            double prev = acc.getBalance();
            acc.setBalance(prev + amount);
            repo.save(acc);

            map.put("Initial Balance", prev);
            map.put("Amount Deposited", amount);
            map.put("Current Balance", acc.getBalance());
            return map;
        } else {
            return map;
        }
    }

}
