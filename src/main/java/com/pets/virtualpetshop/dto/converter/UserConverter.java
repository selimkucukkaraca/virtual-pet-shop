package com.pets.virtualpetshop.dto.converter;

import com.pets.virtualpetshop.dto.UserDto;
import com.pets.virtualpetshop.dto.request.CreateUserRequest;
import com.pets.virtualpetshop.model.User;
import com.pets.virtualpetshop.model.UserType;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserDto convertToDto(User from){
        return new UserDto(
                from.getUsername(),
                from.getMail(),
                from.getImageUrl(),
                String.valueOf(from.getUserType()),
                from.isActive()
        );
    }

    public User toEntity(CreateUserRequest request){
        return new User(
                request.getUsername(),
                request.getPassword(),
                request.getMail(),
                request.getImageUrl(),
                UserType.valueOf(request.getUserType())
        );
    }
}