package com.pets.virtualpetshop.dto.request;

import lombok.Data;

@Data
public class CreateFoodAdvertRequest {
    private String FoodPublicId;
    private String title;
    private String body;
    private String imageUrl;
    private String advertDate;
    private String advertUpdateDate;
}