package com.geekbrains.dao;

import com.geekbrains.models.Buyer;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class BuyerRepository {
    public List<Buyer> buyers = new ArrayList<>();

    @Autowired()
    @Qualifier("session")
    Session session;

    public List<Buyer> getAll(){
        buyers = session.createQuery("from Buyer").getResultList();
        return buyers;
    }

    public Buyer findById(Long id){
            return session.find(Buyer.class, id);
    }

    public void create(Buyer buyer){
        buyers.add(buyer);
        session.save(buyer);
        session.getTransaction().commit();
    }

    public void deleteById(Long id) {
        buyers.removeIf(p -> Objects.equals(p.getId(), id));
        session.createQuery("delete from Buyer where id = " + id.intValue()).executeUpdate();
        session.getTransaction().commit();
    }
}
