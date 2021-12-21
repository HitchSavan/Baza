package com.hitchsavan.randommathsite.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "available_products")
public class AvailabilityProduct {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private long id;

    @ManyToOne
    @JoinColumn(name = "availability_id")
    @Getter @Setter private Availability availability;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @Getter @Setter private Product product;

    @Getter @Setter private long amount;

    public AvailabilityProduct() {}

    public AvailabilityProduct(Availability availability, Product product, long amount) {
        this.availability = availability;
        this.product = product;
        this.amount = amount;
    }
}
