package com.pets.virtualpetshop.controller;

import com.pets.virtualpetshop.dto.PetFoodTypeDto;
import com.pets.virtualpetshop.dto.request.CreatePetFoodTypeRequest;
import com.pets.virtualpetshop.service.PetFoodTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pet")
@CrossOrigin
public class PetFoodTypeController {

    private final PetFoodTypeService petFoodTypeService;

    public PetFoodTypeController(PetFoodTypeService petFoodTypeService) {
        this.petFoodTypeService = petFoodTypeService;
    }

    @PostMapping
    public ResponseEntity<PetFoodTypeDto> save(@RequestBody CreatePetFoodTypeRequest request){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(petFoodTypeService.save(request));
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam String typeOfFood){
        petFoodTypeService.delete(typeOfFood);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<PetFoodTypeDto>> getAll() {
        return ResponseEntity
                .ok(petFoodTypeService.getAll());
    }
}
