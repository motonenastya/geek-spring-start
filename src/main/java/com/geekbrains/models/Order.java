//package com.geekbrains.models;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
//@Entity
//@Table(name = "orders")
//public class Order {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Long id;
//
//    @Column(name = "buyer_id")
//    private Long buyer_id;
//
//    @Column(name = "product_id")
//    private Long product_id;
//
//    public Order() {
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Long getBuyer_id() {
//        return buyer_id;
//    }
//
//    public void setBuyer_id(Long buyer_id) {
//        this.buyer_id = buyer_id;
//    }
//
//    public Long getProduct_id() {
//        return product_id;
//    }
//
//    public void setProduct_id(Long product_id) {
//        this.product_id = product_id;
//    }
//
//    public Order(Long id, Long buyer_id, Long product_id) {
//        this.id = id;
//        this.buyer_id = buyer_id;
//        this.product_id = product_id;
//    }
//
//    @Override
//    public String toString() {
//        return "Order [" + id + " " + buyer_id + product_id + "]";
//    }
//}
