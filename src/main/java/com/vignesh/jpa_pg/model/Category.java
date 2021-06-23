package com.vignesh.jpa_pg.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@Data
public class Category {
    @Id
    @GeneratedValue(generator = "categorySeq")
    @SequenceGenerator(name = "categorySeq",sequenceName = "category_seq",allocationSize = 1)
    private long categoryId;
    private String categoryName;
}
