package com.pets.virtualpetshop.repository;

import com.pets.virtualpetshop.model.PetFoodType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetFoodTypeRepository extends JpaRepository<PetFoodType,Long> {

    PetFoodType findPetFoodTypeByTypeOfFood(String typeOfFood);
}
