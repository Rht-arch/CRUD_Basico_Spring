package com.example.spring.Controladores;

import com.example.spring.Clases.Prestamo;
import com.example.spring.Interfaces.PrestamoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/prestamo")
    public ResponseEntity<Prestamo> addPrestamo(@Valid @RequestBody Prestamo prestamo) {
        Prestamo p = this.prestamoRepository.save(prestamo);
        return ResponseEntity.ok().body(p);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Prestamo> updatePrestamo(@Valid @RequestBody Prestamo prestamo, @PathVariable int id) {
        Prestamo p = prestamoRepository.save(prestamo);
        return ResponseEntity.ok().body(p);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePrestamo(@PathVariable int id) {
        prestamoRepository.deleteById(id);
        return ResponseEntity.ok().body("Prestamo deleted");
    }
}
