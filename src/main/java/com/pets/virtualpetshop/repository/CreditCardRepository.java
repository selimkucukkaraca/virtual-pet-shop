package com.pets.virtualpetshop.repository;

import com.pets.virtualpetshop.model.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepository extends JpaRepository<CreditCard,Long> {
}
