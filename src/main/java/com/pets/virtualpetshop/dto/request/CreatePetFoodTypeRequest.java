package com.pets.virtualpetshop.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreatePetFoodTypeRequest {
    private String typeOfFood;
    private String brand;
}
