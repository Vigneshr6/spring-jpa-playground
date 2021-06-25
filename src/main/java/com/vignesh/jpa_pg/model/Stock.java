package com.vignesh.jpa_pg.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Stock {
    @EmbeddedId
    private StockId stockId;
    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    private Store store;
    @JsonManagedReference
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;
    private long quantity;
}
