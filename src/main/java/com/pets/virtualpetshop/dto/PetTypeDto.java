package com.pets.virtualpetshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PetTypeDto extends BaseDto {
    private String typeOfAnimal;
    private String breedOfAnimal;
}
