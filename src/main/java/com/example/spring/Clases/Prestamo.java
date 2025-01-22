package com.example.spring.Clases;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Prestamo {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "ejemplar_id", nullable = false)
    private Ejemplar ejemplar;

    @NotNull
    @Column(name = "fechaInicio", nullable = false)
    private LocalDate fechaInicio;

    @NotNull
    @Column(name = "fechaDevolucion", nullable = false)
    private LocalDate fechaDevolucion;

    public Prestamo(Integer id, Usuario usuario, Ejemplar ejemplar, LocalDate fechaInicio,LocalDate fechaDevolucion) {
        this.id = id;
        this.usuario = usuario;
        this.ejemplar = ejemplar;
        this.fechaInicio = fechaInicio;
        this.fechaDevolucion = fechaDevolucion;
    }

    public Prestamo() {

    }
}