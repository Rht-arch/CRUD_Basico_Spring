package com.example.spring.Clases;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Data
@Entity
public class Prestamo {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @NotBlank
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @NotNull
    @NotBlank
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "ejemplar_id", nullable = false)
    private Ejemplar ejemplar;

    @NotNull
    @NotBlank
    @Column(name = "fechaInicio", nullable = false)
    private LocalDate fechaInicio;

    @NotNull
    @NotBlank
    @Column(name = "fechaDevolucion", nullable = false)
    private LocalDate fechaDevolucion;



    public Prestamo() {

    }
}