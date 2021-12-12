package com.hitchsavan.randommathsite.models;

import java.sql.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "order")
public class Order {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @Getter @Setter private Product product;

    @ManyToOne
    @JoinColumn(name = "shop_id")
    @Getter @Setter private Shop shop;

    @NotBlank
    @Getter @Setter private long amount;

    @NotBlank
    @Getter @Setter private String status;

    @NotBlank
    @Getter @Setter private Date date;

    public Order() {}

    public Order(long id, Product product, Shop shop, long amount, String status, Date date) {
        this.id = id;
        this.product = product;
        this.shop = shop;
        this.amount = amount;
        this.status = status;
        this.date = date;
    }
}
