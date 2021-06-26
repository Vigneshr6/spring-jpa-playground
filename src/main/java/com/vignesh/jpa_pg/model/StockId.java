package com.vignesh.jpa_pg.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Data
public class StockId implements Serializable {
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    private Store store;
    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;
}
