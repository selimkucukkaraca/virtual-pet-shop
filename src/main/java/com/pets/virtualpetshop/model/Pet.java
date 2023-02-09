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
public class Pet extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private PetType petType;
    private int age;
    private String gender;
    private String publicId = UUID.randomUUID().toString();

    public Pet(PetType petType, int age, String gender) {
        this.petType = petType;
        this.age = age;
        this.gender = gender;
    }
}
