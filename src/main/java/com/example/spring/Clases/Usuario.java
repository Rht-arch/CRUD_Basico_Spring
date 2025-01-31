package com.example.spring.Clases;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "Usuario")

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 15)
    @NotNull
    @NotBlank
    @Column(name = "dni", nullable = false, length = 15)
    @Pattern(regexp = "^[0-9]{8}[A-HJ-NP-TV-Z]$", message = "El DNI no es valido")
    private String dni;

    @Size(max = 100)
    @NotNull
    @NotBlank
    @Column(name = "nombre", nullable = false, length = 100)
    @Pattern(regexp = "^[A-Za-z0-9]+( [A-Za-z0-9]+)*$", message = "Nombre incorrecto")
    private String nombre;

    @Size(max = 100)
    @NotNull
    @NotBlank
    @Column(name = "email", nullable = false, length = 100)
    @Pattern(regexp = "^[A-Za-z0-9]{1,50}@gmail.com$", message = "Solo validos gmail")
    private String email;

    @Size(max = 255)
    @NotNull
    @NotBlank
    @Column(name = "password", nullable = false)
    @Pattern(regexp = "^[a-zA-Z0-9]{4,12}$", message = "La contraseña debe llevar valores alfanumericos y una longitud minima de 4 caracteres y maxima de 12")
    private String password;

    @NotNull
    @NotBlank
    @Lob
    @Column(name = "tipo", nullable = false)
    @Pattern(regexp = "^(normal|administrador)$", message = "El usuario solo puede ser normal o administrador")
    private String tipo;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "penalizacionHasta", nullable = true)
    private LocalDate penalizacionHasta;


    public Usuario() {

    }
}