package com.pets.virtualpetshop.service;

import com.pets.virtualpetshop.dto.PetTypeDto;
import com.pets.virtualpetshop.dto.request.CreatePetTypeRequest;
import com.pets.virtualpetshop.model.PetType;
import com.pets.virtualpetshop.repository.PetTypeRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PetTypeService {

    private final PetTypeRepository petTypeRepository;

    public PetTypeService(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    public PetTypeDto save(CreatePetTypeRequest request){
        var saved = new PetType(request.getTypeOfAnimal(), request.getBreedOfAnimal());
        petTypeRepository.save(saved);
        return new PetTypeDto(saved.getTypeOfAnimal(),saved.getBreedOfAnimal());
    }

    public PetType getPetTypeByType(String typeOfAnimal,String breedOfAnimal){
        return petTypeRepository.findPetTypeByTypeOfAnimalAndBreedOfAnimal(typeOfAnimal,breedOfAnimal);
    }

    public void delete(String typeOfAnimal, String breedOfAnimal){
        var fromType = getPetTypeByType(typeOfAnimal, breedOfAnimal);
        petTypeRepository.delete(fromType);
    }

    public List<PetTypeDto> getAll(){
        return petTypeRepository.findAll()
                .stream()
                .map(petType -> new PetTypeDto(petType.getTypeOfAnimal(), petType.getBreedOfAnimal()))
                .collect(Collectors.toList());
    }
}