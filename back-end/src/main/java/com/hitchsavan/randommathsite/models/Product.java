package com.hitchsavan.randommathsite.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table( name = "product")
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private long id;

    @NotBlank
    @Size(max = 50)
    @Getter @Setter private String name;

    @NotBlank
    @Getter @Setter private long amount;

    @NotBlank
    @Getter @Setter private long price;

    @OneToMany(mappedBy = "product")
    @Getter @Setter private Set<Order> order = new HashSet<Order>();

    @OneToMany(mappedBy = "product")
    @Getter @Setter private Set<Availability> availability = new HashSet<Availability>();

    public Product() {}

    public Product(long id, String name, long amount, long price) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public void addShop(Order shop) {
        this.order.add(shop);
    }

    public void addOrder(Order order) {
        this.order.add(order);
    }

    public void addShop(Availability shop) {
        this.availability.add(shop);
    }

    public void addAvailability(Availability availability) {
        this.availability.add(availability);
    }
}
