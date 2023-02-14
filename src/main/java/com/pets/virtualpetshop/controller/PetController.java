package com.pets.virtualpetshop.controller;

import com.pets.virtualpetshop.dto.PetDto;
import com.pets.virtualpetshop.dto.request.CreatePetRequest;
import com.pets.virtualpetshop.service.PetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pet")
@CrossOrigin
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping
    public ResponseEntity<PetDto> save(@RequestBody CreatePetRequest request){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(petService.save(request));
    }

    @GetMapping("/{publicId}")
    public ResponseEntity<PetDto> getByPublicId (@PathVariable String publicId){
        return ResponseEntity
                .ok(petService.getByPublicId(publicId));
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam String publicid){
        petService.delete(publicid);
        return ResponseEntity.noContent().build();
    }
}