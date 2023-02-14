package com.pets.virtualpetshop.dto.converter;

import com.pets.virtualpetshop.dto.FoodAdvertDto;
import com.pets.virtualpetshop.dto.request.CreateFoodAdvertRequest;
import com.pets.virtualpetshop.model.FoodAdvert;
import com.pets.virtualpetshop.service.FoodAdvertService;
import com.pets.virtualpetshop.service.PetFoodService;
import org.springframework.stereotype.Component;

@Component
public class FoodAdvertConverter {

    private final FoodAdvertService foodAdvertService;
    private final FoodAdvertConverter foodAdvertConverter;
    private final PetFoodConverter petFoodConverter;
    private final PetFoodService petFoodService;

    public FoodAdvertConverter(FoodAdvertService foodAdvertService,
                               FoodAdvertConverter foodAdvertConverter,
                               PetFoodConverter petFoodConverter, PetFoodService petFoodService) {
        this.foodAdvertService = foodAdvertService;
        this.foodAdvertConverter = foodAdvertConverter;
        this.petFoodConverter = petFoodConverter;
        this.petFoodService = petFoodService;
    }

    public FoodAdvertDto convertToDto(FoodAdvert from){
        return new FoodAdvertDto(
                from.getPublicId(),
                from.getTitle(),
                from.getBody(),
                from.getImageUrl(),
                from.getAdvertDate(),
                from.getAdvertUpdateDate(),
                petFoodConverter.convertToDto(from.getPetFood())
        );
    }

    public FoodAdvert toEntity(CreateFoodAdvertRequest request){
        return new FoodAdvert(
                request.getTitle(),
                request.getBody(),
                request.getImageUrl(),
                request.getAdvertDate(),
                request.getAdvertUpdateDate(),
                petFoodService.getPetFoodByPublicId(request.getFoodPublicId())
        );
    }
}