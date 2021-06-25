package com.vignesh.jpa_pg.model;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import java.io.Serializable;

@Embeddable
@Data
public class StockId implements Serializable {
    @JoinColumn(name = "store_id")
    private long storeId;
    @JoinColumn(name = "product_id")
    private long productId;

    public StockId(long storeId, long productId) {
        this.storeId = storeId;
        this.productId = productId;
    }
}
