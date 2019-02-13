package com.client.app.springangular.repositories;

import com.client.app.springangular.models.Contact;

import org.springframework.data.repository.CrudRepository;

/**
 * ContactRepository
 */
public interface ContactRepository extends CrudRepository<Contact,String>{

    
}