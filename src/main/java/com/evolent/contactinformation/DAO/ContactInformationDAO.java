/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evolent.contactinformation.DAO;

import com.evolent.contactinformation.model.Contact;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This is DAO class to connect with JPA and database layer.
 * @author sweta.upadhyay
 */
@Repository
public interface ContactInformationDAO extends JpaRepository<Contact, Long> {

}
