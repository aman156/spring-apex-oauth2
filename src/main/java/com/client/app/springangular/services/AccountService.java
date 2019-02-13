package com.client.app.springangular.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.client.app.springangular.models.Account;
import com.client.app.springangular.repositories.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * AccountService
 */
@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRep;

    public List<Account> findAllAccounts()
    {
        List<Account> accountList = new ArrayList<>();
        accountRep.findAll().forEach(accountList::add);
        return accountList;
    }

    public Account getAccount(String id) {
        Optional<Account> result = accountRep.findById(id);
        return result.get();

    }

    public Account saveAccount(Account account) 
    {
        account = accountRep.save(account);
        return account;
    }
    public void deleteAccount(String id) 
    {
        accountRep.deleteById(id);
        return;
    }
}