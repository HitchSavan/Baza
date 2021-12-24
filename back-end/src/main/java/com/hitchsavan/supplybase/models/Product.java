package com.hitchsavan.supplybase.models;

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

    @Getter @Setter private long amount;

    @Getter @Setter private long price;

    @OneToMany(mappedBy = "product")
    @Setter Set<AvailableProducts> availability = new HashSet<>();

    @OneToMany(mappedBy = "product")
    @Setter Set<OrderedProducts> orders = new HashSet<>();

    public Product() {}

    public Product(String name, long amount, long price) {
        this.name = name;
        this.amount = amount;
        this.price = price;
    }
}
