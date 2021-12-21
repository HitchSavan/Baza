package com.hitchsavan.randommathsite.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table( name = "availability")
public class Availability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private long id;
    
    @OneToMany(mappedBy = "availability")
    @Setter private Set<AvailabilityProduct> availableProducts = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "shop_id")
    @Getter @Setter private Shop shop;

    public Availability() {}

    public Availability(Shop shop) {
        this.shop = shop;
    }
}
