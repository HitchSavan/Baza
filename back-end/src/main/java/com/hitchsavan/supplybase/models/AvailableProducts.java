package com.hitchsavan.supplybase.models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.Getter;
import lombok.Setter;

@Entity
public class AvailableProducts {
    
    @EmbeddedId
    @Getter @Setter private AvailabilityId id;

    @ManyToOne
    @MapsId("available_id")
    @JoinColumn(name = "available_id")
    @Setter private Availability available;

    @ManyToOne
    @MapsId("product_id")
    @JoinColumn(name = "product_id")
    @Getter @Setter private Product product;

    @Getter @Setter private long amount;

    public AvailableProducts() {}

    public AvailableProducts(long amount) {
        this.amount = amount;
    }
}
