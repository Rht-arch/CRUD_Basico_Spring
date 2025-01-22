package com.example.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ejemplares")
public class EjemplarControllerMOCK {
    EjemplarRepository ejemplarRepository;

    public EjemplarControllerMOCK() {
    }
    @Autowired
    public EjemplarControllerMOCK(EjemplarRepository ejemplarRepository) {
        this.ejemplarRepository = ejemplarRepository;
    }
    @GetMapping
    public ResponseEntity<List<Ejemplar>> findAll() {
        List<Ejemplar> ejemplars = ejemplarRepository.findAll();
        System.out.println(ejemplars);
        return ResponseEntity.ok(ejemplars);
    }
}
