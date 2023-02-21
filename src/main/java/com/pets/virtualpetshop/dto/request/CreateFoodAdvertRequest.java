package com.pets.virtualpetshop.dto.request;

import lombok.Data;

@Data
public class CreateFoodAdvertRequest {
    private String foodPublicId;
    private String title;
    private String body;
    private String imageUrl;
    private String advertDate;
    private String advertUpdateDate;
    private double price;
}