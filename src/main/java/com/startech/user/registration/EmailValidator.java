package com.startech.user.registration;

import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class EmailValidator implements Predicate<String>{

    @Override
    public boolean test(String t) {
        //validacion regex para el email
        return true;
    }
    
}
