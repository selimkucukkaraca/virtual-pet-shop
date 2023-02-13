package com.pets.virtualpetshop.dto.converter;

import com.pets.virtualpetshop.dto.PetFoodDto;
import com.pets.virtualpetshop.dto.request.CreatePetFoodRequest;
import com.pets.virtualpetshop.model.PetFood;
import com.pets.virtualpetshop.model.PetFoodType;
import com.pets.virtualpetshop.service.PetFoodTypeService;
import org.springframework.stereotype.Component;

@Component
public class PetFoodConverter {

    private final PetFoodTypeService petFoodTypeService;

    public PetFoodConverter(PetFoodTypeService petFoodTypeService) {
        this.petFoodTypeService = petFoodTypeService;
    }

    public PetFoodDto convertToDto(PetFood from){
        return new PetFoodDto(
                new PetFoodType(
                        from.getPetFoodType().getTypeOfFood(),
                        from.getPetFoodType().getBrand()),
                from.getKg(),
                from.getPublicId()
        );
    }

    public PetFood toEntity(CreatePetFoodRequest request){
        return new PetFood(
                petFoodTypeService.getPetFoodTypeByType(request.getTypeOfFood()),
                request.getKg()
        );
    }
}
