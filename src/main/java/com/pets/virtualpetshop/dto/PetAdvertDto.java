package com.pets.virtualpetshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PetAdvertDto extends BaseDto {
    private String publicId;
    private String location;
    private String title;
    private String body;
    private String imageUrl;
    private String advertDate;
    private String advertUpdateDate;
    private PetDto petDto;
}
