package com.pets.virtualpetshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PetDto extends BaseDto{
    private PetTypeDto petType;
    private int age;
    private String gender;
    private String publicId;
}
