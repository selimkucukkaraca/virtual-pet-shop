package com.pets.virtualpetshop.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PetFood extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private PetFoodType petFoodType;
    private int Kg;
    private String publicId = UUID.randomUUID().toString();

    public PetFood(PetFoodType petFoodType, int kg) {
        this.petFoodType = petFoodType;
        Kg = kg;
    }
}
