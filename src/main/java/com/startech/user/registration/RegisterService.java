package com.startech.user.registration;

import org.springframework.stereotype.Service;

import com.startech.user.Role;
import com.startech.user.User;
import com.startech.user.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RegisterService {

    private final UserService userService;

    private final EmailValidator emailValidator;

    public String register(RegisterRequest request) {

        boolean isCorrectEmail = emailValidator.test(request.getEmail());

        if(!isCorrectEmail){
            throw new IllegalStateException("correo no valido");
        }

        String token = userService.signUpUser(
            new User(
                request.getName(),
                request.getLastName(),
                request.getEmail(),
                request.getPassword(),
                Role.USER
            )
        );
        return token;
    }

    
    
}
