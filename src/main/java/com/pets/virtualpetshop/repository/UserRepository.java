package com.pets.virtualpetshop.repository;

import com.pets.virtualpetshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findUserByMail(String mail);
    boolean existsUserByMail(String mail);
}
