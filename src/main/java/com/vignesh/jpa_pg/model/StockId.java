package com.vignesh.jpa_pg.model;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class StockId implements Serializable {
    private long storeId;
    private long productId;

    public StockId(long storeId, long productId) {
        this.storeId = storeId;
        this.productId = productId;
    }
}
