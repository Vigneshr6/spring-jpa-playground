package com.vignesh.jpa_pg.controller;

import com.vignesh.jpa_pg.model.Customer;
import com.vignesh.jpa_pg.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/customers")
@Slf4j
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping
    public List<Customer> getAllCustomers() {
        List<Customer> all = (List<Customer>) customerRepository.findAll();
        log.debug("count : " + all.size());
        return all;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity getCustomer(@PathVariable long id) throws CustomerNotFoundException {
        try {
            Customer customer = customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
            log.debug("fetch completed");
            return ResponseEntity.ok(customer);
        } catch (CustomerNotFoundException e) {
            return new ResponseEntity(NOT_FOUND);
        }
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public Customer save(@RequestBody Customer employee) {
        log.debug("Customer : {}", employee);
        return customerRepository.save(employee);
    }

    @PutMapping(value = "/{id}", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity update(@PathVariable Long id, @RequestBody Customer employee) {
        Customer empOld;
        try {
            Customer customer = customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
            empOld = customerRepository.save(customer);
        } catch (CustomerNotFoundException e) {
            return new ResponseEntity(NOT_FOUND);
        }
        return new ResponseEntity(empOld, OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        customerRepository.deleteById(id);
        return new ResponseEntity(OK);
    }
}
