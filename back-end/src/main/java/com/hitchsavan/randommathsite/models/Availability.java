package com.hitchsavan.randommathsite.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table( name = "availability")
public class Availability {
    
    @EmbeddedId
    @Getter @Setter private AvailabilityId id;
    /*
    @ManyToOne
    @JoinColumn(name = "product_id")
    @Getter @Setter private Product product;

    @ManyToOne
    @JoinColumn(name = "shop_id")
    @Getter @Setter private Shop shop;
    */
    @NotBlank
    @Getter @Setter private long amount;

    public Availability() {}
    
    public Availability(long amount) {
        this.amount = amount;
    }
}
