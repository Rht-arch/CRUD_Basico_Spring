package com.example.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/prestamos")
public class PrestamoControllerMOCK {
    PrestamoRepository prestamoRepository;

    public PrestamoControllerMOCK() {
    }

    @Autowired
    public PrestamoControllerMOCK(PrestamoRepository prestamoRepository) {
        this.prestamoRepository = prestamoRepository;
    }
    @GetMapping
    public ResponseEntity<List<Prestamo>> getAllPrestamos() {
        List<Prestamo> prestamos = prestamoRepository.findAll();
        System.out.println(prestamos);
        return ResponseEntity.ok(prestamos);
    }

}
