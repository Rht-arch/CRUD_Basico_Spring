package com.example.spring.Interfaces;

import com.example.spring.Clases.Ejemplar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EjemplarRepository extends JpaRepository<Ejemplar, String> {

}
