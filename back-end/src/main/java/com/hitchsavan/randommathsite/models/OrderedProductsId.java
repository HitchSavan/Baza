package com.hitchsavan.randommathsite.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Embeddable
public class OrderedProductsId implements Serializable {
    
    @Column(name = "order_id")
    @Getter @Setter long order_id;

    @Column(name = "product_id")
    @Getter @Setter long product_id;

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof OrderedProductsId)) {
            return false;
        }
        OrderedProductsId orderedProductsId = (OrderedProductsId) o;
        return order_id == orderedProductsId.order_id && product_id == orderedProductsId.product_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(order_id, product_id);
    }
}
