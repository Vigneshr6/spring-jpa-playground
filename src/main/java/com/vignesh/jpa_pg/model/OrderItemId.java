package com.vignesh.jpa_pg.model;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class OrderItemId implements Serializable {
    private long orderId;
    private long itemId;
}
