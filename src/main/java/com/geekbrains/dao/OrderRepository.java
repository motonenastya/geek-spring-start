package com.geekbrains.dao;

import com.geekbrains.models.Order;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository {
    public static List<Order> listOrder = new ArrayList<>();

    @Autowired()
    @Qualifier("session")
    Session session;

    public List<Order> findAll(){
        listOrder = session.createQuery("from Order").getResultList();
        return listOrder;
    }

    public List<Order> findById(Long buyerId){
        listOrder = session.createQuery("from Order where buyer_id = " + buyerId.intValue()).getResultList();
        return listOrder;
    }
}
