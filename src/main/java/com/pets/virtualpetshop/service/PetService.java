package com.pets.virtualpetshop.service;

import com.pets.virtualpetshop.dto.PetDto;
import com.pets.virtualpetshop.dto.converter.PetConverter;
import com.pets.virtualpetshop.dto.request.CreatePetRequest;
import com.pets.virtualpetshop.exception.NotFoundException;
import com.pets.virtualpetshop.exception.generic.GenericExistException;
import com.pets.virtualpetshop.model.Pet;
import com.pets.virtualpetshop.repository.ConfirmCodeRepository;
import com.pets.virtualpetshop.repository.PetRepository;
import com.pets.virtualpetshop.util.MailSendService;
import org.springframework.stereotype.Service;


@Service
public class PetService {

    private final MailSendService mailSendService;
    private final ConfirmCodeService confirmCodeService;
    private final PetRepository petRepository;
    private final PetConverter petConverter;
    private final ConfirmCodeRepository confirmCodeRepository;

    public PetService(MailSendService mailSendService,
                      ConfirmCodeService confirmCodeservice, PetRepository petRepository,
                      PetConverter petConverter, ConfirmCodeRepository confirmCodeRepository) {
        this.mailSendService = mailSendService;
        this.confirmCodeService = confirmCodeservice;
        this.petRepository = petRepository;
        this.petConverter = petConverter;
        this.confirmCodeRepository = confirmCodeRepository;
    }

    public PetDto save(CreatePetRequest request){
        var saved = petConverter.toEntity(request);
        if (petRepository.existsPetByPublicId(saved.getPublicId())){
            throw new GenericExistException("user already exist , mail : " + saved.getPublicId());
        }
        petRepository.save(saved);
        return petConverter.convertToDto(saved);
    }

    public PetDto getByPublicId(String PublicId){
        var fromDb = petRepository.findPetByPublicId(PublicId)
                .orElseThrow(() -> new NotFoundException("publicId not found : " + PublicId));

        return petConverter.convertToDto(fromDb);
    }

    public void delete(String publicId){
        var fromPet = getPetByPublicId(publicId);
        petRepository.delete(fromPet);
    }

    public Pet getPetByPublicId(String PublicId){
        return petRepository.findPetByPublicId(PublicId)
                .orElseThrow(() -> new NotFoundException(""));
    }


}
