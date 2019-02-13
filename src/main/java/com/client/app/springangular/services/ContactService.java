
package com.client.app.springangular.services;

import java.util.ArrayList;
import java.util.List;

import com.client.app.springangular.models.Contact;
import com.client.app.springangular.repositories.ContactRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ContactService
 */
@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRep;

    public List<Contact> findAllContacts(){
        List<Contact> contactList = new ArrayList<>();
        contactRep.findAll().forEach(contactList::add);
        return contactList;
    }
    
}