/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evolent.contactinformation.controller;

import com.evolent.contactinformation.model.Contact;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Unit test class for Controller.
 *
 * @author sweta.upadhyay
 */
public class ContactControllerTest {

    @Test
    public void testCreateContact() {

        ContactInformationController controller = Mockito.mock(ContactInformationController.class);
        Contact contact = Mockito.mock(Contact.class);
        when(controller.createContact(contact)).thenReturn(contact);

    }

    @Test
    public void testGetAllContacts() throws Exception {

        ContactInformationController controller = Mockito.mock(ContactInformationController.class);
        Contact contact = Mockito.mock(Contact.class);
        List<Contact> contacts = Arrays.asList(contact);
        when(controller.getAllContacts()).thenReturn(contacts);
    }

    @Test
    public void testDeleteContact() throws Exception {
        ContactInformationController controller = Mockito.mock(ContactInformationController.class);
        ResponseEntity responseEntity = new ResponseEntity<>(null, HttpStatus.OK);
        when(controller.deleteContact(1L)).thenReturn(responseEntity);
        
    }

}
