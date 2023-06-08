package com.startech.user.registration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegisterRequest {

    private final String name;
    private final String lastName;
    private final String email;
    private final String password;
    
}
