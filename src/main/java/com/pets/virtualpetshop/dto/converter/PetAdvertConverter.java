package com.pets.virtualpetshop.dto.converter;

import com.pets.virtualpetshop.dto.PetAdvertDto;
import com.pets.virtualpetshop.dto.request.CreatePetAdvertRequest;
import com.pets.virtualpetshop.model.PetAdvert;
import com.pets.virtualpetshop.service.PetService;
import org.springframework.stereotype.Component;

@Component
public class PetAdvertConverter {

    private final PetConverter petConverter;
    private final PetService petService;

    public PetAdvertConverter(PetConverter petConverter,
                              PetService petService) {
        this.petConverter = petConverter;
        this.petService = petService;
    }

    public PetAdvertDto convertToDto(PetAdvert from){
        return new PetAdvertDto(
                from.getPublicId(),
                from.getLocation(),
                from.getTitle(),
                from.getBody(),
                from.getImageUrl(),
                from.getAdvertDate(),
                from.getAdvertUpdateDate(),
                petConverter.convertToDto(from.getPet())
        );
    }

    public PetAdvert toEntity(CreatePetAdvertRequest request){
        return new PetAdvert(
                request.getLocation(),
                request.getTitle(),
                request.getBody(),
                request.getImageUrl(),
                request.getAdvertDate(),
                request.getAdvertUpdateDate(),
                petService.getPetByPublicId(request.getPetPublicId())
        );
    }
}
