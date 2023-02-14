package com.geekbrains.dao;

import com.geekbrains.models.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class ProductRepository {
    public List<Product> products = new ArrayList<>();
//    public static Session thisSession = null;

    public static Session thisSession;

    @Autowired()
    @Qualifier("factory")
    SessionFactory factory;

//    public static void getSession(Session session){
//        thisSession = session;
//    }

    public List<Product> getAllProducts(){
//       products = thisSession.createQuery("from Product").getResultList();
        thisSession = factory.getCurrentSession();
        thisSession.beginTransaction();
        products = thisSession.createQuery("from Product").getResultList();
        return products;
    }

    public Product findById(Long id){
//            return products.get(id.intValue() - products.size() - 1);
        return products.stream().filter(product -> product.getId() == id).findAny().orElse(null);
//        так мы в одну строчку находим товар по id, а если такого товара нет - возвращаем null
    }

    public void createNewProduct(Product product){
        thisSession = factory.getCurrentSession();
        thisSession.beginTransaction();

        products.add(product);

            thisSession.save(product);
            thisSession.getTransaction().commit();
    }

    public void delete(Long id) {
        thisSession.createQuery("delete from Product where id = " + id.intValue()).executeUpdate();
        products.removeIf(p -> Objects.equals(p.getId(), id));
        thisSession.getTransaction().commit();
    }
}
