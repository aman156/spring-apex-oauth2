package com.client.app.springangular.repositories;

import com.client.app.springangular.models.Account;

import org.springframework.data.repository.CrudRepository;

/**
 * AccountRepository
 */
public interface AccountRepository extends CrudRepository<Account,String>{

    
}