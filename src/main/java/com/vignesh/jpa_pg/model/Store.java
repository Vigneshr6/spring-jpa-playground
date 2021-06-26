package com.vignesh.jpa_pg.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonBackReference
    @OneToMany(mappedBy = "store")
    private List<Staff> staffs;
    @JsonBackReference
    @OneToMany(mappedBy = "store")
    private List<Order> orders;
    @JsonManagedReference
    @OneToMany(mappedBy = "stockId.store")
    private List<Stock> stocks;
}
