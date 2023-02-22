package com.pets.virtualpetshop.service;

import com.pets.virtualpetshop.model.BuyPetAdvert;
import com.pets.virtualpetshop.repository.BuyPetAdvertRepository;
import org.springframework.stereotype.Service;

@Service
public class BuyPetAdvertService {

    private final BuyPetAdvertRepository buyPetAdvertRepository;

    public BuyPetAdvertService(BuyPetAdvertRepository buyPetAdvertRepository) {
        this.buyPetAdvertRepository = buyPetAdvertRepository;
    }

    public BuyPetAdvert save(BuyPetAdvert buyPetAdvert){
        return buyPetAdvertRepository.save(buyPetAdvert);
    }
}
