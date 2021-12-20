package com.hitchsavan.randommathsite.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table( name = "shop")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private long id;

    @NotBlank
    @Size(max = 50)
    @Getter @Setter private String name;

    @OneToMany(mappedBy = "shop")
    @Getter @Setter private Set<Order> order = new HashSet<Order>();

    @OneToMany
    @JoinColumns(
        @JoinColumn(
            name = "shop_id",
            referencedColumnName = "id")
    )
    @Getter @Setter private Set<Availability> availability = new HashSet<Availability>();

    public Shop() {}

    public Shop(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addOrder(Order order) {
        this.order.add(order);
    }
}
