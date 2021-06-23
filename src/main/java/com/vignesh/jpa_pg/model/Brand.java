package com.vignesh.jpa_pg.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@Data
public class Brand {
    @Id
    @GeneratedValue(generator = "brandSeq")
    @SequenceGenerator(name = "brandSeq",sequenceName = "brand_seq",allocationSize = 1)
    private long brandId;
    private String brandName;
}
