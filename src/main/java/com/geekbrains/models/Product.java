package com.geekbrains.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private int price;

    @ManyToMany
    @JoinTable(name = "orders",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "buyer_id"))
    private List<Buyer> buyers = new ArrayList<>();

    public Product(Long id, String title, int price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getInfo(){
        return id + ", " + title + ", " + price + "\n";
    }

    public List<Buyer> getBuyers() {
        return buyers;
    }

    public void setBuyers(List<Buyer> buyers) {
        this.buyers = buyers;
    }

    @Override
    public String toString() {
        return "Product [" + id + " " + title + " " + price + "] ";
    }
}
