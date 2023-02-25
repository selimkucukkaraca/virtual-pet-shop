package com.pets.virtualpetshop.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreatePetRequest {
    private String typeOfAnimal;
    private String breedOfAnimal;
    private int age;
    private String gender;
}
