package com.pets.virtualpetshop.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pet extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private PetType petType;
    private int age;
    private String gender;

    public Pet(PetType petType, int age, String gender) {
        this.petType = petType;
        this.age = age;
        this.gender = gender;
    }
}
