package com.pets.virtualpetshop.dto.converter;

import com.pets.virtualpetshop.dto.PetDto;
import com.pets.virtualpetshop.dto.PetTypeDto;
import com.pets.virtualpetshop.model.Pet;
import org.springframework.stereotype.Component;

@Component
public class PetConverter {

    public PetDto convertToDto(Pet from) {
        return new PetDto(
                new PetTypeDto(
                        from.getPetType().getTypeOfAnimal(),
                        from.getPetType().getBreedOfAnimal()),
                from.getAge(),
                from.getGender(),
                from.getPublicId()
        );
    }
}
