package com.startech.computer;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

import com.startech.brand.Brand;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Computer {

    @Id
    @Column(name="id_computer") 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    @NotBlank(message = "El campo descripción no puede estar en blanco o nulo")
    private String description;

    @Column(precision = 10, scale = 2)
    @PositiveOrZero(message = "precio no puede ser un valor negativo")
    private BigDecimal price;

    @PositiveOrZero(message = "El campo stock debe ser un número positivo o cero")
    private int stock;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_brand", nullable = false)
    private Brand brand;
    
}
