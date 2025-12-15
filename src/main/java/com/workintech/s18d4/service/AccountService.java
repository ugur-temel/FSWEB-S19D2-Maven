package com.workintech.s18d4.service;

import com.workintech.s18d4.entity.Account;

import java.util.List;

public interface AccountService {

    public List<Account> findAll();
    public Account find(long id);
    public Account save(Account account);
    public Account update(long customerId, Account account);
    public Account delete(long id);
}
