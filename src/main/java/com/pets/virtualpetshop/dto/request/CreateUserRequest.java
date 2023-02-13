package com.pets.virtualpetshop.dto.request;

import lombok.Data;

@Data
public class CreateUserRequest {
    private String username;
    private String password;
    private String mail;
    private String imageUrl;
    private String userType;
}
