package com.hitchsavan.supplybase.controllers;

import java.util.List;
import java.util.Objects;

import com.hitchsavan.supplybase.models.Product;
import com.hitchsavan.supplybase.repository.ProductRepository;

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
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<Product> getProducts() {
        return (List<Product>) productRepository.findAll();
    }

    @PostMapping
    void addProduct(@RequestBody Product product) {
        productRepository.save(product);
    }

    @DeleteMapping(path = "{id}")
    void deleteProduct(@PathVariable("id") Long id) {
        if(!productRepository.existsById(id)) {
            throw new IllegalStateException(
                "Product with " + id + "does not exist"
            );
        }
        productRepository.deleteById(id);
    }

    @PutMapping(path = "{id}")
    void updateProduct( @PathVariable("id") Long id,
                        @RequestParam(required = false) String name,
                        @RequestParam(required = false) long amount,
                        @RequestParam(required = false) long price) {
        Product product = productRepository.findById(id)
            .orElseThrow(() -> new IllegalStateException(
                "Product with " + id + "does not exist"
            ));
        
        if(name != null && name.length() > 0 &&
            !Objects.equals(product.getName(), name)) {
                product.setName(name);
            }

        if(!Objects.equals(product.getAmount(), amount)) {
                product.setAmount(amount);
            }

        if(price > 0 &&
            !Objects.equals(product.getPrice(), price)) {
                product.setPrice(price);
            }
    }
}
