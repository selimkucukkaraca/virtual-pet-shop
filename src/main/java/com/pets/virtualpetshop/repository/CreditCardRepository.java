package com.pets.virtualpetshop.repository;

import com.pets.virtualpetshop.dto.request.CreditCardRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepository extends JpaRepository<CreditCardRequest,Long> {
}
