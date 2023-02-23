package com.geekbrains.dao;

import com.geekbrains.models.Product;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class ProductRepository {
    public List<Product> products = new ArrayList<>();

    @Autowired()
    @Qualifier("session")
    Session session;

    public List<Product> getAll(){
        products = session.createQuery("from Product").getResultList();
        return products;
    }

    public Product findById(Long id){
        products = session.createQuery("from Product where id = " + id.intValue()).getResultList();
        for (Product product: products)
            return product;
        return null;
//        return products.stream().filter(product -> product.getId() == id).findAny().orElse(null);
//        так мы в одну строчку находим товар по id, а если такого товара нет - возвращаем null
    }

    public void create(Product product){
        products.add(product);
        session.save(product);
        session.getTransaction().commit();
    }

    public void deleteById(Long id) {
        products.removeIf(p -> Objects.equals(p.getId(), id));
        session.createQuery("delete from Product where id = " + id.intValue()).executeUpdate();
        session.getTransaction().commit();
    }
}
