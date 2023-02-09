package com.pets.virtualpetshop.repository;

import com.pets.virtualpetshop.model.PetFood;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PetFoodRepository extends JpaRepository<PetFood,Long> {

    Optional<PetFood> findPetFoodByPublicId(String publicId);
}
