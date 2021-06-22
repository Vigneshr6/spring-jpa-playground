package com.vignesh.jpa_pg.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Store {
    @Id
    @GeneratedValue(generator = "storeSeq")
    @SequenceGenerator(name = "storeSeq",sequenceName = "store_seq")
    private long storeId;
    private String storeName;
    private String phone;
    private String email;
    @Embedded
    private Address address;
    @OneToMany
    private List<Staff> staffs;
    @OneToMany
    private List<Order> orders;
    @ManyToMany
    @MapsId("storeId")
    private List<Stock> stocks;
}
