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

    @ManyToOne
    @JoinColumn(name = "shop_id")
    @Getter @Setter private Shop shop;
    
    @OneToMany(mappedBy = "available")
    @Getter @Setter Set<AvailableProducts> availableProducts = new HashSet<>();
}
