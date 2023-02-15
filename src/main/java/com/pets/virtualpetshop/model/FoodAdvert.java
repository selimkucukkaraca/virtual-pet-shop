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
public class FoodAdvert extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String publicId = UUID.randomUUID().toString();
    private String title;
    private String body;
    private String imageUrl;
    private String advertDate;
    private String advertUpdateDate;
    @ManyToOne
    private PetFood petFood;

    public FoodAdvert(String title, String body, String imageUrl
            ,String advertDate, String advertUpdateDate, PetFood petFood) {
        this.title = title;
        this.body = body;
        this.imageUrl = imageUrl;
        this.advertDate = advertDate;
        this.advertUpdateDate = advertUpdateDate;
        this.petFood = petFood;
    }
}