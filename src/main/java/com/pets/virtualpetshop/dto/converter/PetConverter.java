package com.pets.virtualpetshop.dto.converter;

import com.pets.virtualpetshop.dto.PetDto;
import com.pets.virtualpetshop.dto.PetTypeDto;
import com.pets.virtualpetshop.dto.request.CreatePetRequest;
import com.pets.virtualpetshop.model.Pet;
import com.pets.virtualpetshop.service.PetTypeService;
import org.springframework.stereotype.Component;

@Component
public class PetConverter {

    private final PetTypeService petTypeService;

    public PetConverter(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

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

    public Pet toEntity(CreatePetRequest request){
        return new Pet(
                petTypeService.getPetTypeByType(request.getTypeOfAnimal(),
                        request.getBreedOfAnimal()),
                request.getAge(),
                request.getGender()
        );
    }
}
