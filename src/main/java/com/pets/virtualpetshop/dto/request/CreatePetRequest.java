package com.pets.virtualpetshop.dto.request;

import lombok.Data;

@Data
public class CreatePetRequest {
    private String typeOfAnimal;
    private String breedOfAnimal;
    private int age;
    private String gender;
}
