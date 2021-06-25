package com.vignesh.jpa_pg.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Staff {
    @Id
    @GeneratedValue(generator = "staffSeq")
    @SequenceGenerator(name = "staffSeq",sequenceName = "staff_seq",allocationSize = 1)
    private long staffId;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    @Column(columnDefinition = "INT(1)")
    private Boolean active;
    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "manager_id")
//    private Staff manager;
}
