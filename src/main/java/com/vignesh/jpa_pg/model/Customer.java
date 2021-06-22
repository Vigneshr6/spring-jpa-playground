package com.vignesh.jpa_pg.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(generator = "customerSeq")
    @SequenceGenerator(name = "customerSeq", sequenceName = "customer_seq")
    //sequenceName is the actual name
    //name is the reference for generator
    private long customerId;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    @Embedded
    private Address address;
    @OneToMany(mappedBy = "customer")
    private List<Order> orders;
}
