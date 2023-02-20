package com.pets.virtualpetshop.service;

import com.pets.virtualpetshop.dto.UserDto;
import com.pets.virtualpetshop.dto.converter.UserConverter;
import com.pets.virtualpetshop.dto.request.CreateUserRequest;
import com.pets.virtualpetshop.exception.NotFoundException;
import com.pets.virtualpetshop.exception.generic.GenericExistException;
import com.pets.virtualpetshop.model.ConfirmCode;
import com.pets.virtualpetshop.model.User;
import com.pets.virtualpetshop.repository.ConfirmCodeRepository;
import com.pets.virtualpetshop.repository.UserRepository;
import com.pets.virtualpetshop.util.MailSendService;
import org.springframework.stereotype.Service;

import static com.pets.virtualpetshop.util.MailConstant.*;

@Service
public class UserService {

    private final MailSendService mailSendService;
    private final ConfirmCodeService confirmCodeService;
    private final UserRepository userRepository;
    private final UserConverter userConverter;
    private final ConfirmCodeRepository confirmCodeRepository;

    public UserService(MailSendService mailSendService,
                       ConfirmCodeService confirmCodeService,
                       UserRepository userRepository,
                       UserConverter userConverter,
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

    public UserDto getByMail(String mail){
        var fromDbUser = userRepository.findUserByMail(mail)
                .orElseThrow(() -> new NotFoundException("mail not found : " + mail));
        return userConverter.convertToDto(fromDbUser);
    }

    public void delete(String mail){
        var fromUser = getUserByMail(mail);
        userRepository.delete(fromUser);
    }

    public User getUserByMail(String mail){
        return userRepository.findUserByMail(mail)
                .orElseThrow(() -> new NotFoundException(""));
    }

    public void sendConfirmCode(String mail){
        var user = getUserByMail(mail);

        ConfirmCode confirmCode = new ConfirmCode();
        confirmCodeService.save(confirmCode);
        user.setConfirmCode(confirmCode);
        userRepository.save(user);
        String description = String.format(CONFIRM_CODE_DESCRIPTION, confirmCode.getCode());
        mailSendService.sendMail(user.getMail(),CONFIRM_CODE_TITLE,description);
    }

    public UserDto activeUser(String mail,int code){
        var user = getUserByMail(mail);

        if (user.getConfirmCode().getCode() == code) {
            user.setActive(true);
            confirmCodeRepository.deleteById(user.getConfirmCode().getId());
            userRepository.save(user);
            return userConverter.convertToDto(user);
        }
        return null;
    }

    public UserDto deactivateUser(String mail) {
        var fromDbUser = getUserByMail(mail);
        fromDbUser.setActive(false);
        userRepository.save(fromDbUser);
        return userConverter.convertToDto(fromDbUser);
    }
}