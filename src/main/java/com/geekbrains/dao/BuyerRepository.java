package com.geekbrains.dao;

import com.geekbrains.models.Buyer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class BuyerRepository {
    public List<Buyer> buyers = new ArrayList<>();

    public static Session thisSession;

    @Autowired()
    @Qualifier("factory")
    SessionFactory factory;

    public List<Buyer> getAll(){
        thisSession = factory.getCurrentSession();
        thisSession.beginTransaction();
        buyers = thisSession.createQuery("from Buyer").getResultList();
        return buyers;
    }

    public Buyer findById(Long id){
        thisSession = factory.getCurrentSession();
        thisSession.beginTransaction();
        buyers = thisSession.createQuery("from Buyer where id = " + id.intValue()).getResultList();
        for (Buyer buyer: buyers)
            return buyer;
        return null;
    }

    public void create(Buyer buyer){
        thisSession = factory.getCurrentSession();
        thisSession.beginTransaction();
        buyers.add(buyer);
        thisSession.save(buyer);
        thisSession.getTransaction().commit();
    }

    public void deleteById(Long id) {
        thisSession = factory.getCurrentSession();
        thisSession.beginTransaction();
        buyers.removeIf(p -> Objects.equals(p.getId(), id));
        thisSession.createQuery("delete from Buyer where id = " + id.intValue()).executeUpdate();
        thisSession.getTransaction().commit();
    }
}
