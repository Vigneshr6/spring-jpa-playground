package com.vignesh.jpa_pg.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Stock {
    @EmbeddedId
    private StockId orderId;
    @ManyToOne
    private Store store;
    @ManyToOne
    private Product product;
    private long quantity;
}
