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

    @ManyToOne
    @JoinColumn(name = "shop_id")
    @Getter @Setter private Shop shop;
    
    @OneToMany(mappedBy = "order")
    @Getter @Setter Set<OrderedProducts> orders = new HashSet<>();

    @NotBlank
    @Getter @Setter private String status;

    @Getter @Setter private Date date;

    public Orders() {}

    public Orders(String status, Date date) {
        this.status = status;
        this.date = date;
    }
}
