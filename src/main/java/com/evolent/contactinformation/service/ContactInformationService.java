/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evolent.contactinformation.service;

import com.evolent.contactinformation.model.Contact;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author sweta.upadhyay
 */
public interface ContactInformationService {

    public List<Contact> findAll();

    /**
     * Find by Id.
     *
     * @param id contact id.
     * @return contact.
     */
    public Optional<Contact> findById(Long id);

    /**
     * Save contact in DB.
     *
     * @param contact
     * @return saved contact.
     */
    public Contact save(Contact contact);

    /**
     * Delete contact by id.
     *
     * @param id contact id.
     */
    public void deleteById(Long id);

    /**
     * Update Contact with details.
     *
     * @param contact contact details.
     * @param id contact id.
     * @return updated contact.
     */
    public Contact updateContact(Contact contact, long id);

}
