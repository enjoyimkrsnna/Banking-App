package com.krishna.banking.service.impl;

import com.krishna.banking.dto.AccountDto;
import com.krishna.banking.entity.Account;
import com.krishna.banking.mapper.AccountMapper;
import com.krishna.banking.repository.AccountRepository;
import com.krishna.banking.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {

        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.maptoAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountbyId(Long id) {

       Account account = accountRepository.findById(id)
               .orElseThrow(()->new RuntimeException("Account does not exist"));
        return AccountMapper.maptoAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {
        Account account = accountRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Account does not exist"));
         double Total = account.getBalance() + amount;
         account.setBalance(Total);
         Account savedAccount = accountRepository.save(account);
        return AccountMapper.maptoAccountDto(savedAccount);
    }

    @Override
    public AccountDto withdrawal(Long id, Double amount) {

        Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account does not exist"));
        double currentAmount = account.getBalance();
        Account saveAccount;
        if(currentAmount>amount)
        {
            double newBalance = currentAmount - amount;
            account.setBalance(newBalance);
            saveAccount =  accountRepository.save(account);
        }else {
            throw  new RuntimeException("balance is low");
        }
        return AccountMapper.maptoAccountDto(saveAccount);
    }

    @Override
    public List<AccountDto> getAllACounts() {

        List<Account> accounts = accountRepository.findAll();
        return accounts.stream().map((account-> AccountMapper.maptoAccountDto(account)))
                .collect(Collectors.toList());

    }


    @Override
    public void deleteAccount(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account does not exist"));

        accountRepository.deleteById(id);

    }
}
