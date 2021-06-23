package com.vignesh.jpa_pg.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Store {
    @Id
    @GeneratedValue(generator = "storeSeq")
    @SequenceGenerator(name = "storeSeq",sequenceName = "store_seq",allocationSize = 1)
    private long storeId;
    private String storeName;
    private String phone;
    private String email;
    @Embedded
    private Address address;
    @OneToMany(mappedBy = "store")
    private List<Staff> staffs;
    @OneToMany(mappedBy = "store")
    private List<Order> orders;
    @ManyToMany
    //@MapsId("storeId")
    private List<Stock> stocks;
}
