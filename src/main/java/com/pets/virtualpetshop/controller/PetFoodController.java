package com.pets.virtualpetshop.controller;

import com.pets.virtualpetshop.dto.PetFoodDto;
import com.pets.virtualpetshop.dto.request.CreatePetFoodRequest;
import com.pets.virtualpetshop.service.PetFoodService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pet-food")
@CrossOrigin
public class PetFoodController {

    private final PetFoodService petFoodService;

    public PetFoodController(PetFoodService petFoodService) {
        this.petFoodService = petFoodService;
    }

    @PostMapping
    public ResponseEntity<PetFoodDto> save(@RequestBody CreatePetFoodRequest request){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(petFoodService.save(request));
    }

    @GetMapping("/{publicId}")
    public ResponseEntity<PetFoodDto> getByPublicId (@PathVariable String publicId){
        return ResponseEntity
                .ok(petFoodService.getByPublicId(publicId));
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam String publicid){
        petFoodService.delete(publicid);
        return ResponseEntity.noContent().build();
    }
}