package com.example.spring;

import jakarta.persistence.Cacheable;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    //GET --> Todos los ejemplares
    @GetMapping
    public ResponseEntity<List<Ejemplar>> findAll() {
        List<Ejemplar> ejemplars = ejemplarRepository.findAll();
        System.out.println(ejemplars);
        return ResponseEntity.ok(ejemplars);
    }
    //GET --> Ejemplares por id
    @GetMapping("/{id}")
    public ResponseEntity<Ejemplar> findByEstado(@PathVariable String estado){
        Ejemplar e = this.ejemplarRepository.findById(estado).get();
        return ResponseEntity.ok(e);
    }

    //POST --> Insertar Ejemplares
    @PostMapping("/ejemplar")
    public ResponseEntity<Ejemplar> add(@Valid @RequestBody Ejemplar ejemplar) {
        System.out.println("Entra aqui");
        Ejemplar e = this.ejemplarRepository.save(ejemplar);
        return ResponseEntity.ok().body(e);
    }
    //UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Ejemplar> update(@Valid @RequestBody Ejemplar ejemplar, @PathVariable String id) {
        Ejemplar persisted = ejemplarRepository.save(ejemplar);
        return ResponseEntity.ok().body(persisted);
    }
    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        ejemplarRepository.deleteById(id);
        String mensaje = "Ejemplar con id " + id + " eliminado";
        return ResponseEntity.ok().body(mensaje);
    }
}
