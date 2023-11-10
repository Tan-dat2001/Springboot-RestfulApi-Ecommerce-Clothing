package com.clothing.service;

import com.clothing.dto.UserDto;
import com.clothing.entity.User;
import com.clothing.registration.RegistrationRequest;

public interface UserService {

    String signUpUser(RegistrationRequest registrationRequest);
}
