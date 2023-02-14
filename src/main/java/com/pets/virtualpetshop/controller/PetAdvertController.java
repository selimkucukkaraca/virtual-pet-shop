package com.pets.virtualpetshop.controller;

import com.pets.virtualpetshop.dto.PetAdvertDto;
import com.pets.virtualpetshop.dto.request.CreatePetAdvertRequest;
import com.pets.virtualpetshop.service.PetAdvertService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pet-advert")
@CrossOrigin
public class PetAdvertController {

    private final PetAdvertService petAdvertService;

    public PetAdvertController(PetAdvertService petAdvertService) {
        this.petAdvertService = petAdvertService;
    }

    @PostMapping
    public ResponseEntity<PetAdvertDto> save(@RequestBody CreatePetAdvertRequest request){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(petAdvertService.save(request));
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam String publicId){
        petAdvertService.delete(publicId);
        return ResponseEntity.noContent().build();
    }
}