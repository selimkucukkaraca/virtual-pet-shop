package com.pets.virtualpetshop.repository;

import com.pets.virtualpetshop.model.FoodAdvert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FoodAdvertRepository extends JpaRepository<FoodAdvert,Long> {

    Optional<FoodAdvert> findFoodAdvertByPublicId(String publicId);
    boolean existsFoodAdvertByPublicId(String publicId);
}
