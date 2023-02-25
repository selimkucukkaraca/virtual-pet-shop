package com.pets.virtualpetshop.repository;

import com.pets.virtualpetshop.dto.PetDto;
import com.pets.virtualpetshop.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PetRepository extends JpaRepository<Pet,Long> {
    Optional<Pet> findPetByPublicId(String publicId);
    boolean existsPetByPublicId(String publicId);
}