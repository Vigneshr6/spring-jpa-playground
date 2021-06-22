package com.vignesh.jpa_pg.model;

import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
@Data
public class OrderItem {
    @EmbeddedId
    private OrderItemId id;
    @ManyToOne
    @MapsId("itemId")
    private Product product;
    private long quantity;
    private float listPrice;
    private float discount;
}
