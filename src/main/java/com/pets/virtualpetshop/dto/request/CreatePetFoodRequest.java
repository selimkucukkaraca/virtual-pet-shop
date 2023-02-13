package com.pets.virtualpetshop.dto.request;

import lombok.Data;

@Data
public class CreatePetFoodRequest {
    private String typeOfFood;
    private String brand;
    private int Kg;
}
