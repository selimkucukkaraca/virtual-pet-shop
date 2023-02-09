package com.pets.virtualpetshop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PetFoodType extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String typeOfFood;
    private String brand;

    public PetFoodType(String typeOfFood, String brand) {
        this.typeOfFood = typeOfFood;
        this.brand = brand;
    }
}
