package com.startech.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_role") 
    private Long id;

    @Column(name="role_name") 
    @NotBlank(message = "El campo rol no puede estar en blanco o nulo")
    private String role;
    
}
