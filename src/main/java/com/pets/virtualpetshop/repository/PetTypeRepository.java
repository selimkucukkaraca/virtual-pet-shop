package com.pets.virtualpetshop.repository;

import com.pets.virtualpetshop.model.PetType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetTypeRepository extends JpaRepository<PetType,Long> {
    PetType findPetTypeByTypeOfAnimalAndBreedOfAnimal(String typeOfAnimal,String breedOfAnimal);
}
