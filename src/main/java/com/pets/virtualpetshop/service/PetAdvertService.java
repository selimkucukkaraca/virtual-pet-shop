package com.pets.virtualpetshop.service;

import com.pets.virtualpetshop.dto.PetAdvertDto;
import com.pets.virtualpetshop.dto.converter.PetAdvertConverter;
import com.pets.virtualpetshop.dto.request.CreatePetAdvertRequest;
import com.pets.virtualpetshop.exception.NotFoundException;
import com.pets.virtualpetshop.exception.generic.GenericExistException;
import com.pets.virtualpetshop.model.PetAdvert;
import com.pets.virtualpetshop.repository.PetAdvertRepository;
import org.springframework.stereotype.Service;

@Service
public class PetAdvertService {

    private final PetAdvertRepository petAdvertRepository;
    private final PetAdvertConverter petAdvertConverter;

    public PetAdvertService(PetAdvertRepository petAdvertRepository, PetAdvertConverter petAdvertConverter) {
        this.petAdvertRepository = petAdvertRepository ;
        this.petAdvertConverter = petAdvertConverter;
    }

    public PetAdvertDto save(CreatePetAdvertRequest request){
        var saved = petAdvertConverter.toEntity(request);
        if (petAdvertRepository.existsPetAdvertByPublicId(saved.getPublicId())){
            throw new GenericExistException("public id already exist , public id : " + saved.getPublicId());
        }
        petAdvertRepository.save(saved);
        return petAdvertConverter.convertToDto(saved);
    }

    public void delete(String publicId){
        var fromPetAdvert = getPetAdvertByPublicId(publicId);
        petAdvertRepository.delete(fromPetAdvert);
    }

    public PetAdvert getPetAdvertByPublicId(String publicId){
        return petAdvertRepository.findPetAdvertByPublicId(publicId)
                .orElseThrow(()-> new NotFoundException(""));
    }
}
