package com.example.spring.Interfaces;

import com.example.spring.Clases.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibrosRepository extends JpaRepository<Libro,String> {
    Libro findByIsbn(String isbn);

}
