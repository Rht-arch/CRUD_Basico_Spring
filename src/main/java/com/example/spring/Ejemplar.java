package com.example.spring;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
public class Ejemplar {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @ColumnDefault("'Disponible'")
    @Lob
    @Column(name = "estado")
    private String estado;

    public Ejemplar(Integer id, String estado) {
        this.id = id;
        this.estado = estado;
    }

    public Ejemplar() {

    }
}