package com.pets.virtualpetshop.dto.request;

import lombok.Data;

@Data
public class CreatePetFoodTypeRequest {
    private String typeOfFood;
    private String brand;
}
