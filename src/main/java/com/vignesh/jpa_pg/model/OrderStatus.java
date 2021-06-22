package com.vignesh.jpa_pg.model;

public enum OrderStatus {
    PENDING(1), PROCESSING(2), REJECTED(3), COMPLETED(4);
    Integer code;

    OrderStatus(Integer code) {
        this.code = code;
    }
}
