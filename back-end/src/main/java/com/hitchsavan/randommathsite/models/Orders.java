package com.hitchsavan.randommathsite.models;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "orders")
public class Orders {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private long id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable( name = "ordered_products",
                joinColumns = @JoinColumn(name = "order_id"),
                inverseJoinColumns = @JoinColumn(name = "product_id"))
    @Getter @Setter private Set<Product> product = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "shop_id")
    @Getter @Setter private Shop shop;

    @Getter @Setter private long amount;

    @NotBlank
    @Getter @Setter private String status;

    @Getter @Setter private Date date;

    public Orders() {}

    public Orders(Shop shop, long amount, String status, Date date) {
        this.shop = shop;
        this.amount = amount;
        this.status = status;
        this.date = date;
    }
}
