/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evolent.contactinformation.controller;

import com.evolent.contactinformation.DAO.ContactDAO;
import com.evolent.contactinformation.exception.ContactNotFoundException;
import com.evolent.contactinformation.model.Contact;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author sweta.upadhyay
 */
@RestController
@RequestMapping("/evolent")
public class ContactController {

    @Autowired
    private ContactDAO contactDao;

    @GetMapping("/contacts")
    public List<Contact> getAllContacts() {
        return contactDao.findAll();
    }

    @GetMapping("/contacts/{id}")
    public Contact getContact(@PathVariable long id) {
        Optional<Contact> contact = contactDao.findById(id);

        if (!contact.isPresent()) {
            throw new ContactNotFoundException("id-" + id);
        }

        return contact.get();
    }

    @DeleteMapping("/contacts/delete/{id}")
    public void deleteContact(@PathVariable long id) {
        contactDao.deleteById(id);
    }

    @PostMapping("/contacts/create")
    public ResponseEntity<Object> createContact(@RequestBody Contact contact) {
        Contact saved = contactDao.save(contact);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(saved.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

    @PutMapping("/contacts/update/{id}")
    public ResponseEntity<Object> updateContact(@RequestBody Contact contact, @PathVariable long id) {

        Optional<Contact> contactOptional = contactDao.findById(id);
        if (!contactOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Contact existingContact = contactOptional.get();
        existingContact.setFirstName(contact.getFirstName());
        existingContact.setLastName(contact.getLastName());
        existingContact.setEmail(contact.getEmail());
        existingContact.setPhoneNumber(contact.getPhoneNumber());
        existingContact.setStatus(contact.getStatus());
        contactDao.save(existingContact);

        return ResponseEntity.noContent().build();
    }

}
