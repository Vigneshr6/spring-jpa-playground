package com.vignesh.jpa_pg.model;

import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Stock {
    @EmbeddedId
    private StockId orderId;
    @ManyToOne(fetch = FetchType.LAZY)
    private Store store;
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;
    private long quantity;
}
