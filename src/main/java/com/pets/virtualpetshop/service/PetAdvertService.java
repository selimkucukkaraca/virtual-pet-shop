package com.pets.virtualpetshop.service;

import com.pets.virtualpetshop.dto.PetAdvertDto;
import com.pets.virtualpetshop.dto.converter.PetAdvertConverter;
import com.pets.virtualpetshop.dto.request.CreatePetAdvertRequest;
import com.pets.virtualpetshop.exception.NotFoundException;
import com.pets.virtualpetshop.exception.generic.GenericExistException;
import com.pets.virtualpetshop.model.BuyPetAdvert;
import com.pets.virtualpetshop.model.PetAdvert;
import com.pets.virtualpetshop.repository.PetAdvertRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PetAdvertService {

    private final PetAdvertRepository petAdvertRepository;
    private final PetAdvertConverter petAdvertConverter;
    private final UserService userService;
    private final BuyPetAdvertService buyPetAdvertService;

    public PetAdvertService(PetAdvertRepository petAdvertRepository, PetAdvertConverter petAdvertConverter,
                            UserService userService, BuyPetAdvertService buyPetAdvertService) {
        this.petAdvertRepository = petAdvertRepository ;
        this.petAdvertConverter = petAdvertConverter;
        this.userService = userService;
        this.buyPetAdvertService = buyPetAdvertService;
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

    public List<PetAdvertDto> getAll(int page, int size){
        Pageable pageable = PageRequest.of(page,size);

        return petAdvertRepository.findAll(pageable)
                .stream()
                .map(petAdvertConverter::convertToDto)
                .toList();
    }

    public void buy(String mail, String publicId){
        var fromDbPetAdvert = getPetAdvertByPublicId(publicId);
        var user = userService.getUserByMail(mail);

        if (!Objects.equals(user.getMail(), mail)){
            throw new NotFoundException("mail not found");
        }

        BuyPetAdvert buyPetAdvert = new BuyPetAdvert(fromDbPetAdvert);

        buyPetAdvertService.save(buyPetAdvert);
        delete(publicId);
    }
}