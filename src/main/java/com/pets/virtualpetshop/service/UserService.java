package com.pets.virtualpetshop.service;

import com.pets.virtualpetshop.dto.UserDto;
import com.pets.virtualpetshop.dto.converter.UserConverter;
import com.pets.virtualpetshop.dto.request.CreateUserRequest;
import com.pets.virtualpetshop.exception.NotFoundException;
import com.pets.virtualpetshop.exception.generic.GenericExistException;
import com.pets.virtualpetshop.model.User;
import com.pets.virtualpetshop.repository.ConfirmCodeRepository;
import com.pets.virtualpetshop.repository.UserRepository;
import com.pets.virtualpetshop.util.MailSendService;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final MailSendService mailSendService;
    private final ConfirmCodeService confirmCodeService;
    private final UserRepository userRepository;
    private final UserConverter userConverter;
    private final ConfirmCodeRepository confirmCodeRepository; //TODO: create confirm code service class


    public UserService(MailSendService mailSendService,
                       ConfirmCodeService confirmCodeService,
                       UserRepository userRepository, UserConverter userConverter,
                       ConfirmCodeRepository confirmCodeRepository) {
        this.mailSendService = mailSendService;
        this.confirmCodeService = confirmCodeService;
        this.userRepository = userRepository;
        this.userConverter = userConverter;
        this.confirmCodeRepository = confirmCodeRepository;
    }

    public UserDto save(CreateUserRequest request){
        var saved = userConverter.toEntity(request);
        if (userRepository.existsUserByMail(saved.getMail())){
            throw new GenericExistException("user already exist , mail : " + saved.getMail());
        }
        userRepository.save(saved);
        return userConverter.convertToDto(saved);
    }

    /*
    public UserDto getByMail(String mail){
    }
    */

    public void delete(String mail){
        var fromUser = getPetByMail(mail);
        userRepository.delete(fromUser);
    }

    public User getPetByMail(String mail){
        return userRepository.findUserByMail(mail)
                .orElseThrow(() -> new NotFoundException(""));
    }
}

