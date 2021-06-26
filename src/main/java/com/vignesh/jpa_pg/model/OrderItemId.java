package com.vignesh.jpa_pg.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Data
public class OrderItemId implements Serializable {
    @JsonBackReference
    @ManyToOne
    private Order order;
    @JsonBackReference
    @ManyToOne
    private Product product;
}
