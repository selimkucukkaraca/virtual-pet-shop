package com.pets.virtualpetshop.service;

import com.pets.virtualpetshop.dto.PetFoodTypeDto;
import com.pets.virtualpetshop.dto.request.CreatePetFoodTypeRequest;
import com.pets.virtualpetshop.model.PetFoodType;
import com.pets.virtualpetshop.repository.PetFoodTypeRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PetFoodTypeService {

    private final PetFoodTypeRepository petFoodTypeRepository;

    public PetFoodTypeService(PetFoodTypeRepository petFoodTypeRepository) {
        this.petFoodTypeRepository = petFoodTypeRepository;
    }

    public PetFoodTypeDto save(CreatePetFoodTypeRequest request){
        var saved = new PetFoodType(request.getTypeOfFood(), request.getBrand());
        petFoodTypeRepository.save(saved);
        return new PetFoodTypeDto(saved.getTypeOfFood(),saved.getBrand());
    }

    public PetFoodType getPetFoodTypeByType(String TypeOfFood){
        return petFoodTypeRepository.findPetFoodTypeByTypeOfFood(TypeOfFood);
    }

    public void delete(String TypeOfFood){
        var fromType = getPetFoodTypeByType(TypeOfFood);
        petFoodTypeRepository.delete(fromType);
    }

    public List<PetFoodTypeDto> getAll(){
        return petFoodTypeRepository.findAll()
                .stream()
                .map(petFoodType -> new PetFoodTypeDto(petFoodType.getTypeOfFood(), petFoodType.getBrand()))
                .collect(Collectors.toList());
    }
}
