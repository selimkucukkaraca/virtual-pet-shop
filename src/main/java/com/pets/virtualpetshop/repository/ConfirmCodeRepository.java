package com.pets.virtualpetshop.repository;

import com.pets.virtualpetshop.model.ConfirmCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfirmCodeRepository extends JpaRepository<ConfirmCode,Long> {
    ConfirmCode findConfirmCodeByCode(int code);
}