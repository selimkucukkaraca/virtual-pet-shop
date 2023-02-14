package com.pets.virtualpetshop.service;

import com.pets.virtualpetshop.dto.PetDto;
import com.pets.virtualpetshop.dto.converter.PetConverter;
import com.pets.virtualpetshop.dto.request.CreatePetRequest;
import com.pets.virtualpetshop.exception.NotFoundException;
import com.pets.virtualpetshop.exception.generic.GenericExistException;
import com.pets.virtualpetshop.model.Pet;
import com.pets.virtualpetshop.repository.PetRepository;
import org.springframework.stereotype.Service;


@Service
public class PetService {

    private final PetRepository petRepository;
    private final PetConverter petConverter;

    public PetService(PetRepository petRepository, PetConverter petConverter) {
        this.petRepository = petRepository;
        this.petConverter = petConverter;
    }

    public PetDto save(CreatePetRequest request){
        var saved = petConverter.toEntity(request);
        if (petRepository.existsPetByPublicId(saved.getPublicId())){
            throw new GenericExistException("public id already exist , public id : " + saved.getPublicId());
        }
        petRepository.save(saved);
        return petConverter.convertToDto(saved);
    }

    public PetDto getByPublicId(String publicId){
        var fromDb = petRepository.findPetByPublicId(publicId)
                .orElseThrow(() -> new NotFoundException("publicId not found : " + publicId));

        return petConverter.convertToDto(fromDb);
    }

    public void delete(String publicId){
        var fromPet = getPetByPublicId(publicId);
        petRepository.delete(fromPet);
    }

    public Pet getPetByPublicId(String publicId){
        return petRepository.findPetByPublicId(publicId)
                .orElseThrow(() -> new NotFoundException(""));
    }
}