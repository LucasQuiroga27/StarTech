package com.startech.employee;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

import com.startech.user.User;

import lombok.Data;

@Data
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    @PositiveOrZero(message = "El campo teléfono debe ser un número positivo o cero")
    private int phone;

    @NotBlank
    private String address;

    @Column(precision = 10, scale = 2)
    @PositiveOrZero(message = "salario no puede ser un valor negativo")
    private BigDecimal salary;

    @OneToOne
    @JoinColumn(name="user_id")
    private User user;

}
