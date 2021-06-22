package com.vignesh.jpa_pg.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;

@Converter(autoApply = true)
public class OrderStatusConverter implements AttributeConverter<OrderStatus,Integer> {
    @Override
    public Integer convertToDatabaseColumn(OrderStatus orderStatus) {
        return orderStatus.code;
    }

    @Override
    public OrderStatus convertToEntityAttribute(Integer record) {
        return Arrays.stream(OrderStatus.values())
                .filter(os -> os.code == record).findFirst().orElseThrow(IllegalArgumentException::new);
    }
}
