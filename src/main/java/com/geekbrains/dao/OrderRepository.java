package com.geekbrains.dao;

import com.geekbrains.models.Order;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {
    public static List<Order> listOrder = new ArrayList<>();
    public static Session thisSession = null;

    public static void getSession(Session session){
        thisSession = session;
    }

    public static List<Order> findAll(){
        listOrder = thisSession.createQuery("from Order").getResultList();
        return listOrder;
    }

    public static List<Order> findById(Long buyerId){
        listOrder = thisSession.createQuery("from Order where buyer_id = " + buyerId.intValue()).getResultList();
        return listOrder;
    }
}
