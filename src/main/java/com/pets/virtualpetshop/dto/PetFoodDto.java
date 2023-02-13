package com.pets.virtualpetshop.dto;

import com.pets.virtualpetshop.model.PetFoodType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PetFoodDto extends BaseDto{
    private PetFoodType petFoodType;
    private int Kg;
    private String publicId;
}
