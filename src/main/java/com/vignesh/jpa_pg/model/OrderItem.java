package com.vignesh.jpa_pg.model;

import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
@Data
public class OrderItem {
    @EmbeddedId
    private OrderItemId id;
    @ManyToOne(fetch = FetchType.LAZY)
    //@MapsId("itemId")
    private Product product;
    private long quantity;
    private float listPrice;
    private float discount;
}
