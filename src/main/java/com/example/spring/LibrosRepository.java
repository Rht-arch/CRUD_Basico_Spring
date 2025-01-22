package com.example.spring;

import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibrosRepository extends JpaRepository<Libro,String> {
    Libro findByIsbn(String isbn);

}
