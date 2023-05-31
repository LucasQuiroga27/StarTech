package com.startech.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @Column(name="id_user") 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    @NotBlank(message = "El campo nombre no puede estar en blanco o nulo")
    private String name;

    @NotBlank(message = "El campo correo no puede estar en blanco o nulo")
    private String email;

    @NotBlank(message = "El campo contraseña no puede estar en blanco o nulo")
    private String password;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_role", nullable = false)
    private Role role;
    
}
