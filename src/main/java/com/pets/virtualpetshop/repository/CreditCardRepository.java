package com.pets.virtualpetshop.repository;

import com.pets.virtualpetshop.dto.request.CreateCreditCardRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepository extends JpaRepository<CreateCreditCardRequest,Long> {
}
