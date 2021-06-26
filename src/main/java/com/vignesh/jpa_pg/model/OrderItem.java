package com.vignesh.jpa_pg.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@AssociationOverrides({
        @AssociationOverride(name="orderItemId.order",joinColumns = @JoinColumn(name="order_id")),
        @AssociationOverride(name="orderItemId.product",joinColumns = @JoinColumn(name="product_id"))
})
@Data
public class OrderItem {
    @EmbeddedId
    private OrderItemId orderItemId;
    private long quantity;
    private float listPrice;
    private float discount;
}
