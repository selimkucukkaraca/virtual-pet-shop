package com.pets.virtualpetshop.dto.request;

import lombok.Data;

@Data
public class CreatePetTypeRequest {
    private String typeOfAnimal;
    private String breedOfAnimal;
}
