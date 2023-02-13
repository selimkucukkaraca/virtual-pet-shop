package com.pets.virtualpetshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto extends BaseDto {
    private String username;
    private String mail;
    private String imageUrl;
    private String userType;
}
