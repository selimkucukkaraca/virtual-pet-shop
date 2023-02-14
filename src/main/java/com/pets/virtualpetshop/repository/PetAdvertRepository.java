package com.pets.virtualpetshop.repository;

import com.pets.virtualpetshop.model.PetAdvert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PetAdvertRepository extends JpaRepository<PetAdvert,Long> {
    Optional<PetAdvert> findPetAdvertByPublicId(String publicId);
    boolean existsPetAdvertByPublicId(String publicId);

}
