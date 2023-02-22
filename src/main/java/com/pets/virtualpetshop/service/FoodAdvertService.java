package com.pets.virtualpetshop.service;

import com.pets.virtualpetshop.dto.FoodAdvertDto;
import com.pets.virtualpetshop.dto.converter.FoodAdvertConverter;
import com.pets.virtualpetshop.dto.request.CreateFoodAdvertRequest;
import com.pets.virtualpetshop.dto.request.CreditCardRequest;
import com.pets.virtualpetshop.exception.NotFoundException;
import com.pets.virtualpetshop.exception.generic.GenericExistException;
import com.pets.virtualpetshop.model.BankAccount;
import com.pets.virtualpetshop.model.BuyFoodAdvert;
import com.pets.virtualpetshop.model.FoodAdvert;
import com.pets.virtualpetshop.repository.FoodAdvertRepository;
import org.springframework.stereotype.Service;


@Service
public class FoodAdvertService {

    private final FoodAdvertRepository foodAdvertRepository;
    private final FoodAdvertConverter foodAdvertConverter;
    private final BankAccountService bankAccountService;
    private final BuyFoodAdvertService buyFoodAdvertService;

    public FoodAdvertService(FoodAdvertRepository foodAdvertRepository, FoodAdvertConverter foodAdvertConverter,
                             BankAccountService bankAccountService, BuyFoodAdvertService buyFoodAdvertService) {
        this.foodAdvertRepository = foodAdvertRepository;
        this.foodAdvertConverter = foodAdvertConverter;
        this.bankAccountService = bankAccountService;
        this.buyFoodAdvertService = buyFoodAdvertService;
    }

    public FoodAdvertDto save(CreateFoodAdvertRequest request){
        var saved = foodAdvertConverter.toEntity(request);
        if (foodAdvertRepository.existsFoodAdvertByPublicId(saved.getPublicId())){
            throw new GenericExistException("public id already exist , public id : " + saved.getPublicId());
        }
        foodAdvertRepository.save(saved);
        return foodAdvertConverter.convertToDto(saved);
    }

    public void delete(String publicId){
        var fromFoodAdvert = getFoodAdvertByPublicId(publicId);
        foodAdvertRepository.delete(fromFoodAdvert);
    }

    public FoodAdvert getFoodAdvertByPublicId(String publicId){
        return foodAdvertRepository.findFoodAdvertByPublicId(publicId)
                .orElseThrow(()-> new NotFoundException(""));
    }

    public void buy(CreditCardRequest creditCardRequest, String publicId){
        FoodAdvert fromDbFoodAdvert = getFoodAdvertByPublicId(publicId);
        BankAccount bankAccount = bankAccountService.getByCardNumber(creditCardRequest.getCardNumber());

        if (fromDbFoodAdvert.getPrice() > bankAccount.getBalance()){
            throw new RuntimeException("not enough balance");
        }

        bankAccount.setBalance(bankAccount.getBalance() - fromDbFoodAdvert.getPrice());
        BuyFoodAdvert buyFoodAdvert = new BuyFoodAdvert(fromDbFoodAdvert);

        buyFoodAdvertService.save(buyFoodAdvert);
        bankAccountService.save(bankAccount);
        delete(publicId);
    }
}