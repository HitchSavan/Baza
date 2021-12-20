package com.hitchsavan.randommathsite.controllers;

import java.util.List;
import java.util.Objects;

import com.hitchsavan.randommathsite.models.Shop;
import com.hitchsavan.randommathsite.repository.ShopRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shops")
public class ShopController {
    
    private final ShopRepository shopRepository;

    public ShopController(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    @GetMapping
    public List<Shop> getShops() {
        return (List<Shop>) shopRepository.findAll();
    }

    @PostMapping
    void addShop(@RequestBody Shop shop) {
        shopRepository.save(shop);
    }

    @DeleteMapping(path = "{id}")
    void deleteShop(@PathVariable("id") Long id) {
        if(!shopRepository.existsById(id)) {
            throw new IllegalStateException(
                "Shop with " + id + "does not exist"
            );
        }
        shopRepository.deleteById(id);
    }

    @PutMapping(path = "{id}")
    void updateProduct( @PathVariable("id") Long id,
                        @RequestParam(required = false) String name) {
        Shop shop = shopRepository.findById(id)
            .orElseThrow(() -> new IllegalStateException(
                "Shop with " + id + "does not exist"
            ));
        
        if(name != null && name.length() > 0 &&
            !Objects.equals(shop.getName(), name)) {
                shop.setName(name);
            }
    }
}
