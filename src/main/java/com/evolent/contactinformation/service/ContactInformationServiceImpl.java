/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evolent.contactinformation.service;

import com.evolent.contactinformation.DAO.ContactInformationDAO;
import com.evolent.contactinformation.exception.ContactNotFoundException;
import com.evolent.contactinformation.model.Contact;
import com.evolent.contactinformation.model.ContactStatus;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * This class is service layer class to interact with DAO layer.
 * @author sweta.upadhyay
 */

@Service
public class ContactInformationServiceImpl implements ContactInformationService{
   
    @Autowired
    ContactInformationDAO contactDao;

    /**
     * To find all the contacts.
     * @return 
     */
    @Override
    public List<Contact> findAll() {
        return contactDao.findAll();
    }

    /**
     * Find by Id.
     * @param id contact id.
     * @return contact.
     */
    @Override
    public Optional<Contact> findById(Long id) {
        Optional<Contact> contact = contactDao.findById(id);

        if (!contact.isPresent()) {
            throw new ContactNotFoundException("id-" + id);
        }

        return contact;
    }

    /**
     * Save contact in DB.
     * @param contact 
     * @return saved contact.
     */
    @Override
    public Contact save(Contact contact) {
        if(contact.getStatus() == null) {
            contact.setStatus(ContactStatus.ACTIVE);
        }
        return contactDao.save(contact);
    }

    /**
     * Delete contact by id.
     * @param id contact id.
     */
    @Override
    public void deleteById(Long id) {
        contactDao.deleteById(id);
    }
    
    /**
     * Update Contact with details.
     * @param contact contact details.
     * @param id contact id.
     * @return updated contact.
     */
    @Override
    public Contact updateContact(Contact contact, long id) {
        Optional<Contact> contactOptional = contactDao.findById(id);
        if (!contactOptional.isPresent()) {
            return null;
        }
        Contact existingContact = contactOptional.get();
        existingContact.setFirstName(contact.getFirstName());
        existingContact.setLastName(contact.getLastName());
        existingContact.setEmail(contact.getEmail());
        existingContact.setPhoneNumber(contact.getPhoneNumber());
        existingContact.setStatus(contact.getStatus());
        Contact updatedContact = contactDao.save(existingContact);

        return updatedContact;

    }
}
