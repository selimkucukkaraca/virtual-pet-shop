package com.pets.virtualpetshop.controller;

import com.pets.virtualpetshop.dto.FoodAdvertDto;
import com.pets.virtualpetshop.dto.request.CreateFoodAdvertRequest;
import com.pets.virtualpetshop.dto.request.CreditCardRequest;
import com.pets.virtualpetshop.service.FoodAdvertService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/food-advert")
@CrossOrigin
public class FoodAdvertController {

    private final FoodAdvertService foodAdvertService;

    public FoodAdvertController(FoodAdvertService foodAdvertService) {
        this.foodAdvertService = foodAdvertService;
    }

    @PostMapping
    public ResponseEntity<FoodAdvertDto> save(@RequestBody CreateFoodAdvertRequest request){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(foodAdvertService.save(request));
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam String publicId){
        foodAdvertService.delete(publicId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/buy")
    public ResponseEntity<?> buy(@RequestBody CreditCardRequest creditCardRequest,@RequestParam String publicId){
        foodAdvertService.buy(creditCardRequest,publicId);
        return ResponseEntity.noContent().build();
    }
}