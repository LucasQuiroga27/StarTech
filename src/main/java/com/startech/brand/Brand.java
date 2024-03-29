package com.startech.brand;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_brand") 
    private Long id;

    @Column(name="brand_name") 
    @NotBlank(message = "El campo marca no puede estar en blanco o nulo")
    private String brand;
    
}
