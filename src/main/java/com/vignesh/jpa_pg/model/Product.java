package com.vignesh.jpa_pg.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(generator = "productSeq")
    @SequenceGenerator(name = "productSeq",sequenceName = "product_seq",allocationSize = 1)
    private long productId;
    private String productName;
    @ManyToOne(fetch = FetchType.LAZY)
    private Brand band;
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;
    private int modelYear;
    private float listPrice;
    //MapsId is the part of composite key mentioned in Stock Entity
    @ManyToMany
    //@MapsId("productId")
    private List<Stock> stocks;
}
