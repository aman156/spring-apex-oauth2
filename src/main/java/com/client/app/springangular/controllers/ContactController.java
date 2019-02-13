
package com.client.app.springangular.controllers;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.client.app.springangular.models.Contact;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * ContactController
 */
@RestController
public class ContactController {

    @RequestMapping(value="/contacts/", method=RequestMethod.GET)
    public List<Contact> getAllContacts() {
        return null;
    }
    
}