package com.vignesh.jpa_pg.repository;

import com.vignesh.jpa_pg.model.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer,Long> {
    @Query("SELECT c FROM Customer c JOIN c.orders GROUP BY c HAVING COUNT(c) > 2 ORDER BY c.customerId")
    public List<Customer> getCustomerWhoOrderMoreThan2();
}
