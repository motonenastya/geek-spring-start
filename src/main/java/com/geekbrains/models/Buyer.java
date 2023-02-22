package com.geekbrains.models;

import com.geekbrains.dao.OrderRepository;

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
    public static List<Product> products = new ArrayList<>();

    public Buyer() {
    }

    public Long getId() {
        return id;
    }

    public Buyer(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        List<Order> orders = OrderRepository.findById(this.getId());
        String product = "";
        for (Order order:orders) {
            for (Product product1: products)
                if (order.getProduct_id() == product1.getId()){
                    product = product + product1.toString();
                }
        }
        return "Buyer [" + id + " " + name + " " + product + "]";
    }
}

