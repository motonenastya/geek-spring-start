package com.geekbrains.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "buyers")
public class Buyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(name = "orders",
            joinColumns = @JoinColumn(name = "buyer_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    public List<Product> products = new ArrayList<>();

    public Buyer() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Buyer(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    public List<Product> getProducts() {
        return products;
    }
}

