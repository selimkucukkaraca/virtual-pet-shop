package com.pets.virtualpetshop.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BuyFoodAdvert extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private FoodAdvert foodAdvert;

    public BuyFoodAdvert(FoodAdvert foodAdvert) {
        this.foodAdvert = foodAdvert;
    }
}