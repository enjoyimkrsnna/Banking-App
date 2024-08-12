package com.krishna.banking.controller;

import com.krishna.banking.dto.AccountDto;
import com.krishna.banking.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    //add account REST API

    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto)
    {
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    //Get account REST API
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountByID(@PathVariable Long id)
    {
        AccountDto accountDto = accountService.getAccountbyId(id);
        return  ResponseEntity.ok(accountDto);
    }

    //Deposit Balance REST Api
    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id ,@RequestBody Map<String,Double> request){

        AccountDto accountDto  = accountService.deposit(id,request.get("amount"));
        return ResponseEntity.ok(accountDto);
    }

    // Withdraw REST API
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable Long id, @RequestBody Map<String, Double> request)
    {
        try{
            AccountDto accountDto = accountService.withdrawal(id,request.get("amount"));
            return ResponseEntity.ok(accountDto);

        }catch (RuntimeException e)
        {
                return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }

    // GET ALL Account REST API
    @GetMapping()
    public ResponseEntity<List<AccountDto>> getAllAccounts()
    {
        List<AccountDto> accounts = accountService.getAllACounts();
        return ResponseEntity.ok(accounts);
    }

    // Delete Account REST API

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id)
    {
        try {
            accountService.deleteAccount(id);
            return ResponseEntity.ok("deleted");

        }catch (RuntimeException e)
        {
            accountService.deleteAccount(id);
            return ResponseEntity.ok(e.getMessage());
        }

    }
}
