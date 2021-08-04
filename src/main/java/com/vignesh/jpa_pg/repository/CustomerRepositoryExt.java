package com.vignesh.jpa_pg.repository;

import com.vignesh.jpa_pg.model.Customer;

import java.util.List;

public interface CustomerRepositoryExt {
    public List<Customer> getFirst10();
}
