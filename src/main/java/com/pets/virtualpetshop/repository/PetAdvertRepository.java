package com.pets.virtualpetshop.repository;

import com.pets.virtualpetshop.model.PetAdvert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetAdvertRepository extends JpaRepository<PetAdvert,Long> {

}
