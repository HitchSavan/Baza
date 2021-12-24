package com.hitchsavan.supplybase.models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.Getter;
import lombok.Setter;

@Entity
public class OrderedProducts {
    
    @EmbeddedId
    @Getter @Setter private OrderedProductsId id;

    @ManyToOne
    @MapsId("order_id")
    @JoinColumn(name = "order_id")
    @Setter private Orders order;
    
    @ManyToOne
    @MapsId("product_id")
    @JoinColumn(name = "product_id")
    @Getter @Setter private Product product;

    @Getter @Setter private long amount;

    public OrderedProducts() {}

    public OrderedProducts(long amount) {
        this.amount = amount;
    }
}
