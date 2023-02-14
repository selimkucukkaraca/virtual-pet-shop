package com.pets.virtualpetshop.controller;

import com.pets.virtualpetshop.dto.PetTypeDto;
import com.pets.virtualpetshop.dto.request.CreatePetTypeRequest;
import com.pets.virtualpetshop.service.PetTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pet-type")
@CrossOrigin
public class PetTypeController {

    private final PetTypeService petTypeService;

    public PetTypeController(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

    @PostMapping
    public ResponseEntity<PetTypeDto> save(@RequestBody CreatePetTypeRequest request){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(petTypeService.save(request));
    }

    @GetMapping
    public ResponseEntity<List<PetTypeDto>> getAll() {
        return ResponseEntity
                .ok(petTypeService.getAll());
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam String typeOfAnimal, String breedOfAnimal){
        petTypeService.delete(typeOfAnimal,breedOfAnimal);
        return ResponseEntity.noContent().build();
    }
}