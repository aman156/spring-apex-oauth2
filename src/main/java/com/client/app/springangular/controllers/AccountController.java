package com.client.app.springangular.controllers;


import java.util.Arrays;
import java.util.List;

import com.client.app.springangular.Force;
import com.client.app.springangular.models.Account;
import com.client.app.springangular.services.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
public class AccountController {

    /**
     *
     */

    private static final String ACCOUNTS_ID = "/accounts/{id}";

    @Autowired
    private AccountService accountSerivce;

    @Autowired
    private Force force;

    @RequestMapping("/salesforce/accounts")
    public List<Force.Account> getAllSfAccounts(OAuth2Authentication principal){
        return force.accounts(principal);
    }

    @RequestMapping("/accounts")
    public List<Account> getAllAccounts() {
        List<Account> findAllAccounts = accountSerivce.findAllAccounts();
        if(findAllAccounts == null || findAllAccounts.isEmpty())
        {
            findAllAccounts = Arrays.asList(
                        new Account("Aman", "Sharma", "7004"),
                        new Account("Akshay", "Sharma", "8004"),
                        new Account("Dhruv", "Sharma", "9004"),
                        new Account("Maya", "Sharma", "1004")
            );           
        }
        return findAllAccounts;
    }

    @RequestMapping(ACCOUNTS_ID)
    public Account getAccount(@PathVariable String id) {
        Account account =accountSerivce.getAccount(id);
        return account;
    }

    @RequestMapping(value="/accounts/new" , method = RequestMethod.POST)
    public Account createAccount( @RequestBody Account account) 
    {
        account =accountSerivce.saveAccount(account);
        return account;
    }

    @RequestMapping(value="/accounts/edit", method = RequestMethod.PUT)
    public Account updateAccount(@RequestBody Account account) 
    {
        account =accountSerivce.saveAccount(account);
        return account;
    }

    @RequestMapping(value = ACCOUNTS_ID+"/delete", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id) 
    {
        accountSerivce.deleteAccount(id);
    }
    


    
}