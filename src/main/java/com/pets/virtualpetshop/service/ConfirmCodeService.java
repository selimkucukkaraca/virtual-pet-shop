package com.pets.virtualpetshop.service;

import com.pets.virtualpetshop.model.ConfirmCode;
import com.pets.virtualpetshop.repository.ConfirmCodeRepository;
import org.springframework.stereotype.Service;

@Service
public class ConfirmCodeService {
    private final ConfirmCodeRepository confirmCodeRepository;

    public ConfirmCodeService(ConfirmCodeRepository confirmCodeRepository) {
        this.confirmCodeRepository = confirmCodeRepository;
    }

    public void save(ConfirmCode confirmCode){
        confirmCodeRepository.save(confirmCode);
    }

    public void delete(ConfirmCode confirmCode){
        confirmCodeRepository.delete(confirmCode);
    }
}
