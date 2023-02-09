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
public class PetType extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String typeOfAnimal;
    private String breedOfAnimal;

    public PetType(String typeOfAnimal, String breedOfAnimal) {
        this.typeOfAnimal = typeOfAnimal;
        this.breedOfAnimal = breedOfAnimal;
    }
}
