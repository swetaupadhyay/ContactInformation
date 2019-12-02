/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evolent.contactinformation.model;

/**
 *
 * @author sweta.upadhyay
 */
public enum ContactStatus {
    
    ACTIVE("Active"),
    INACTIVE("Inactive");
    
    private final String displayValue;
    ContactStatus(String value) {
        this.displayValue= value;
    }
    
    public String getDisplayValue(){
        return this.displayValue;
    }
    
}
