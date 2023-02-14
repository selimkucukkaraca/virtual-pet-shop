package com.pets.virtualpetshop.dto.request;

import lombok.Data;

@Data
public class CreatePetAdvertRequest {
    private String location;
    private String title;
    private String body;
    private String imageUrl;
    private String advertDate;
    private String advertUpdateDate;
    private String petPublicId;
}