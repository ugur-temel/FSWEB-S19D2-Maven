package com.workintech.s18d4.service;

import com.workintech.s18d4.entity.Account;
import com.workintech.s18d4.entity.Customer;
import com.workintech.s18d4.repository.AccountRepository;
import com.workintech.s18d4.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService{

    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account find(long id) {
        Optional<Account> account = accountRepository.findById(id);
        return account.orElse(null);
    }

    @Override
    public Account save(Account account) {
            return accountRepository.save(account);
    }

    @Override
    public Account update(long customerId, Account account) {
            return accountRepository.save(account);
    }

    @Override
    public Account delete(long id) {
       Optional<Account> accountOptional = accountRepository.findById(id);
       if(accountOptional.isPresent()) {
           Account account = accountOptional.get();
           accountRepository.delete(account);
           return account;
       }
        return null;
    }
}
