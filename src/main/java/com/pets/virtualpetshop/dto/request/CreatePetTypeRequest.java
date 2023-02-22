package com.pets.virtualpetshop.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreatePetTypeRequest {
    private String typeOfAnimal;
    private String breedOfAnimal;
}
