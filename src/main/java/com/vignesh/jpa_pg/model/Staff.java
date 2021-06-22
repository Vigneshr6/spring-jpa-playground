package com.vignesh.jpa_pg.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Staff {
    @Id
    @GeneratedValue(generator = "staffSeq")
    @SequenceGenerator(name = "staffSeq",sequenceName = "staff_seq")
    private long staffId;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    @Column(columnDefinition = "INT(1)")
    private Boolean active;
    @ManyToOne
    private Store store;
    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Staff manager;
}
