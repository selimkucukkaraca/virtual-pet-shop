package com.pets.virtualpetshop.dto.request;

import com.pets.virtualpetshop.model.PetType;
import lombok.Data;

@Data
public class CreatePetRequest {
    private PetType petType;
    private int age;
    private String gender;
}
