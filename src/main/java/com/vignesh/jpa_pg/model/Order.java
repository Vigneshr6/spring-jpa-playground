package com.vignesh.jpa_pg.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Order {
    @Id
    @GeneratedValue(generator = "orderSeq")
    @SequenceGenerator(name = "orderSeq",sequenceName = "order_seq",allocationSize = 1)
    private long orderId;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    //name is the column name created in order table for foreign key
    //referencedColumnName is the primary key column name od customer table
    //both of these are no need to be mentioned is same primary key column name is used in foreign key column
    //check the below store mapping
    private Customer customer;
    //This Enum implement converter
    //Check enum code
    private OrderStatus orderStatus;
    private LocalDate orderDate;
    private LocalDate requiredDate;
    private LocalDate shippedDate;
    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;
    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "staff_id")
    private Staff staff;
    @JsonManagedReference
    @OneToMany
    //@MapsId("orderId")
    private List<OrderItem> items;
}
