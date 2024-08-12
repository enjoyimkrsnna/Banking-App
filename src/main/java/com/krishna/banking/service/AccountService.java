package com.krishna.banking.service;


import com.krishna.banking.dto.AccountDto;

import java.util.List;

public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);
    AccountDto getAccountbyId(Long id);

    AccountDto deposit(Long id, double amount);

    AccountDto withdrawal(Long id, Double amount);

    List<AccountDto> getAllACounts();
    void deleteAccount(Long id);
}
