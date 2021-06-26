package com.vignesh.jpa_pg.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@AssociationOverrides({
        @AssociationOverride(name = "stockId.store", joinColumns = @JoinColumn(name = "store_id")),
        @AssociationOverride(name = "stockId.product", joinColumns = @JoinColumn(name = "product_id"))
}
)
@Data
public class Stock {
    @EmbeddedId
    private StockId stockId;
    private long quantity;
}
