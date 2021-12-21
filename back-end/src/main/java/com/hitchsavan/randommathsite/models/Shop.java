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
    @Setter Set<Availability> availability = new HashSet<>();

    public Shop() {}

    public Shop(String name) {
        this.name = name;
    }
}
