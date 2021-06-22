package com.vignesh.jpa_pg.repository;

import com.vignesh.jpa_pg.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Long> {
}
