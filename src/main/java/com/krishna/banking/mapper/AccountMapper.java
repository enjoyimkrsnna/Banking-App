package com.krishna.banking.mapper;

import com.krishna.banking.dto.AccountDto;
import com.krishna.banking.entity.Account;

public class AccountMapper {
    public static Account mapToAccount(AccountDto accountDto)
    {
        Account account = new Account(
                accountDto.getId(),
                accountDto.getAccountHolderName(),
                accountDto.getBalance());

        return account;
    }

    public static AccountDto maptoAccountDto(Account account)
    {
        AccountDto accountDto = new AccountDto(
                account.getId(),
                account.getAccountHolderName(),
                account.getBalance()
        );
        return accountDto;
    }
}
