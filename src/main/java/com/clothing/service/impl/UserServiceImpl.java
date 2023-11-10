package com.clothing.service.impl;

import com.clothing.dto.UserDto;
import com.clothing.entity.User;
import com.clothing.registration.RegistrationRequest;
import com.clothing.registration.code.ConfirmationCode;
import com.clothing.registration.code.ConfirmationCodeService;
import com.clothing.repository.UserRepository;
import com.clothing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ConfirmationCodeService confirmationCodeService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ConfirmationCodeService confirmationCodeService) {
        this.userRepository = userRepository;
        this.confirmationCodeService = confirmationCodeService;

    }

    // todo: registration user that receive 'registrationRequest' parameter
    @Override
    public String signUpUser(RegistrationRequest registrationRequest) {
        Optional<User> userOptional = userRepository.findByEmail(registrationRequest.getEmail());
        // todo: generate random code.
        String code = UUID.randomUUID().toString();

        if (userOptional.isPresent()) {
            // todo: exist User -> get User -> check status 1||0? return "Email already taken": create new code and save it in db with user
            User user = userOptional.get();
            if (0 == user.getStatus()) {
                ConfirmationCode confirmationCode = new ConfirmationCode(code, LocalDateTime.now(), LocalDateTime.now().plusMinutes(5), user);
                confirmationCodeService.saveConfirmationCode(confirmationCode);
                return code;
            } else {
//                todo: return
                return "Email already existed";
            }
        } else {
            //todo: User null -> covert to entity -> save User in db -> create new code and save code with user -> return code to take it and confirm
            User user = registrationRequest.toUserEntity();
            User u = userRepository.save(user);
            ConfirmationCode confirmationCode = new ConfirmationCode(code, LocalDateTime.now(), LocalDateTime.now().plusMinutes(5), u);
            confirmationCodeService.saveConfirmationCode(confirmationCode);
            return code;
        }

        // todo: must encrypt password
        // todo: implement it later ( when we use security )
        // todo: send mail
    }
}

