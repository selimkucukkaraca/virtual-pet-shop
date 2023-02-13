package com.pets.virtualpetshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PetFoodTypeDto extends BaseDto{
    private String typeOfFood;
    private String brand;
}
