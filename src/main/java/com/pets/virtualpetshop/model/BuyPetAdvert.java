package com.pets.virtualpetshop.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BuyPetAdvert extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private PetAdvert petAdvert;

    public BuyPetAdvert(PetAdvert petAdvert) {
        this.petAdvert = petAdvert;
    }
}
