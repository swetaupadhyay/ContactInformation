/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evolent.contactinformation.exception;

/**
 *
 * @author sweta.upadhyay
 */
public class ContactNotFoundException  extends RuntimeException {

  public ContactNotFoundException(String exception) {
    super(exception);
  }
}
