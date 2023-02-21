package com.pets.virtualpetshop.service;

import com.pets.virtualpetshop.model.BuyFoodAdvert;
import com.pets.virtualpetshop.repository.BuyFoodAdvertRepository;
import org.springframework.stereotype.Service;

@Service
public class BuyFoodAdvertService {

    private final BuyFoodAdvertRepository buyFoodAdvertRepository;

    public BuyFoodAdvertService(BuyFoodAdvertRepository buyFoodAdvertRepository) {
        this.buyFoodAdvertRepository = buyFoodAdvertRepository;
    }

    public BuyFoodAdvert save(BuyFoodAdvert buyFoodAdvert){
        return buyFoodAdvertRepository.save(buyFoodAdvert);
    }
}
