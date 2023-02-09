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
public class PetAdvert extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String publicId = UUID.randomUUID().toString();
    private String location;
    private String title;
    private String body;
    private String imageUrl;
    private String advertDate;
    private String advertUpdateDate;
    @ManyToOne
    private Pet pet;

    public PetAdvert(String location, String title, String body,
                     String imageUrl, String advertDate, String advertUpdateDate, Pet pet) {
        this.location = location;
        this.title = title;
        this.body = body;
        this.imageUrl = imageUrl;
        this.advertDate = advertDate;
        this.advertUpdateDate = advertUpdateDate;
        this.pet = pet;
    }
}
