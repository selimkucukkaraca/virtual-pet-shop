package com.pets.virtualpetshop.repository;

import com.pets.virtualpetshop.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

    Optional<Customer> findCustomerByMail(String mail);
    boolean existsCustomerByMail(String mail);
}
