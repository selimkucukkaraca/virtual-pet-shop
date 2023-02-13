package com.pets.virtualpetshop.dto.converter;

import com.pets.virtualpetshop.dto.UserDto;
import com.pets.virtualpetshop.dto.request.CreateUserRequest;
import com.pets.virtualpetshop.model.User;
import com.pets.virtualpetshop.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    private final UserService userService;

    public UserConverter(UserService userService) {
        this.userService = userService;
    }

    public UserDto convertToDto(User from){
        return new UserDto(
                from.getUsername(),
                from.getMail(),
                from.getImageUrl(),
                String.valueOf(from.getUserType())
        );
    }

    public User toEntity(CreateUserRequest request){
        return new User(
                request.getUsername(),
                request.getPassword(),
                request.getMail(),
                request.getImageUrl()
        );
    }
}