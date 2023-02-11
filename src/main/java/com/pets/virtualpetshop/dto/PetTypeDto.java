package com.pets.virtualpetshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PetTypeDto {
    private String typeOfAnimal;
    private String breedOfAnimal;
}
