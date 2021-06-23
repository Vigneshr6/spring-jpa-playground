package com.vignesh.jpa_pg.controller;

public class CustomerNotFoundException extends Exception{
    public CustomerNotFoundException(long id) {
        super(id+" does not exists");
    }
}
