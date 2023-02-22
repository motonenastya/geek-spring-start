package com.geekbrains.service;

import com.geekbrains.dao.BuyerRepository;
import com.geekbrains.models.Buyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyerService {
    private final BuyerRepository buyerRepository;

    @Autowired
    public BuyerService(BuyerRepository buyerRepository) {
        this.buyerRepository = buyerRepository;
    }

    public List<Buyer> getAll(){
        return buyerRepository.getAll();
    }

    public Buyer findById(Long id){
        return buyerRepository.findById(id);
    }

    public void create(Buyer buyer){
        buyerRepository.create(buyer);
    }

    public void deleteById(Long id){
        buyerRepository.deleteById(id);
    }
}
