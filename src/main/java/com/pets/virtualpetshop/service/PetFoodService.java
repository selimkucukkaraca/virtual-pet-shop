package com.pets.virtualpetshop.service;

import com.pets.virtualpetshop.dto.PetFoodDto;
import com.pets.virtualpetshop.dto.converter.PetFoodConverter;
import com.pets.virtualpetshop.dto.request.CreatePetFoodRequest;
import com.pets.virtualpetshop.exception.NotFoundException;
import com.pets.virtualpetshop.model.PetFood;
import com.pets.virtualpetshop.repository.PetFoodRepository;
import org.springframework.stereotype.Service;

@Service
public class PetFoodService {

    private final PetFoodRepository petFoodRepository;
    private final PetFoodConverter petFoodConverter;

    public PetFoodService(PetFoodRepository petFoodRepository, PetFoodConverter petFoodConverter) {
        this.petFoodRepository = petFoodRepository;
        this.petFoodConverter = petFoodConverter;
    }

    public PetFoodDto save(CreatePetFoodRequest request){
        var saved = petFoodConverter.toEntity(request);
        petFoodRepository.save(saved);
        return petFoodConverter.convertToDto(saved);
    }

    public PetFoodDto getByPublicId(String publicId){
        var fromDb = petFoodRepository.findPetFoodByPublicId(publicId)
                .orElseThrow(()-> new NotFoundException("publicId not found : " + publicId));

        return petFoodConverter.convertToDto(fromDb);
    }

    public void delete(String publicId){
        var fromFood = getPetFoodByPublicId(publicId);
        petFoodRepository.delete(fromFood);
    }

    public PetFood getPetFoodByPublicId(String publicId){
        return petFoodRepository.findPetFoodByPublicId(publicId)
                .orElseThrow(()-> new NotFoundException(""));
    }
}