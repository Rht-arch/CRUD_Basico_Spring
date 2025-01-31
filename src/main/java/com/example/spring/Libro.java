package com.example.spring;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
@Entity
public class Libro {
    @Id
    @Size(max = 20)
    @Column(name = "isbn", nullable = false, length = 20)
    @Pattern(regexp = "^[0-9]{9}[0-9X]$|^[0-9]{13}$", message = "ISBN incorrecto")
    private String isbn;

    @Size(max = 200)
    @NotNull
    @NotBlank
    @Column(name = "titulo", nullable = false, length = 200)
    private String titulo;

    @Size(max = 100)
    @NotNull
    @NotBlank
    @Column(name = "autor", nullable = false, length = 100)
    private String autor;

    public Libro(String isbn, String titulo, String autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
    }

    @JsonCreator
    public Libro(@JsonProperty("isbn") String isbn) {
        this.isbn = isbn;
    }

    public Libro() {

    }
}