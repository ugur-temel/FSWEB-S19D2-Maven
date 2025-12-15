package com.workintech.s18d4.controller;

import com.workintech.s18d4.dto.AccountResponse;
import com.workintech.s18d4.entity.Account;
import com.workintech.s18d4.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    public List<AccountResponse> getAllAccounts(){
        List<Account> accounts = accountService.findAll();
        return accounts.stream().map(account -> new AccountResponse("Accounts fetched!", account))
                .collect(Collectors.toList());
    }
    @GetMapping("/{id}")
    public AccountResponse getAccountById(@PathVariable long id){
        Account account = accountService.find(id);
        return new AccountResponse("Account fetched", account);
    }
    @PostMapping("/{customerId}")
    public AccountResponse addAccount(@PathVariable long customerId, @RequestBody Account account){
        Account savedAccount = accountService.save(account);
        return new AccountResponse("Account added", savedAccount);
    }
    @PutMapping("/{customerId}")
    public AccountResponse updateAccount(@PathVariable long customerId, @RequestBody Account account){
        Account updatedAccount = accountService.update(customerId,account);
        return new AccountResponse("Account updated", updatedAccount);
    }
    @DeleteMapping("/{id}")
    public AccountResponse deleteAccount(@PathVariable long id){
        accountService.delete(id);
        return new AccountResponse("Account deleted", id);
    }
}
