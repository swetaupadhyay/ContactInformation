/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evolent.contactinformation.controller;

import com.evolent.contactinformation.model.Contact;
import com.evolent.contactinformation.service.ContactInformationService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class is controller class for Contact information. It would provide the feature to create, update, delete,
 * get details about contact.
 * 
 * @author sweta.upadhyay
 */
@RestController
@RequestMapping("/evolent")
public class ContactInformationController {

    @Autowired
    private ContactInformationService contactInformationService;

    /**
     * Get All contact details.
     * @return list of contacts.
     */
    @GetMapping("/contacts")
    @CrossOrigin
    public List<Contact> getAllContacts() {
        return contactInformationService.findAll();
    }

    /**
     * Get specific contact.
     * @param id contact id.
     * @return  contact.
     */
    @GetMapping("/contacts/{id}")
     @CrossOrigin
    public Contact getContact(@PathVariable long id) {
        Optional<Contact> contact = contactInformationService.findById(id);
        return contact.get();
    }

    /**
     * Delete contact by id.
     * @param id  contact id.
     * @return 
     */
    @DeleteMapping("/contacts/delete/{id}")
    @ResponseStatus( HttpStatus.OK )
    @CrossOrigin
    public ResponseEntity deleteContact(@PathVariable long id) {
        contactInformationService.deleteById(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    /**
     * Create contact details.
     * @param contact new contact.
     * @return Create Contact.
     */
    @PostMapping("/contacts/create")
     @CrossOrigin
    public Contact createContact(@RequestBody Contact contact) {
        Contact saved = contactInformationService.save(contact);
        return saved;

    }

    /** 
     * Update Contact.
     * @param contact Updated details.
     * @param id contact id to which we need to update.
     * @return  update contact.
     */
    @PutMapping("/contacts/update/{id}")
    public Contact updateContact(@RequestBody Contact contact, @PathVariable long id) {
        return contactInformationService.updateContact(contact, id);
    }

}
