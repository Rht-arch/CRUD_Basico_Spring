package com.example.spring;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControllerMOCK {
    UsuarioRepository usuarioRepository;

    public UsuarioControllerMOCK() {
    }
    @Autowired
    public UsuarioControllerMOCK(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    @GetMapping
    public ResponseEntity<List<Usuario>> findAll() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        System.out.println(usuarios);
        return ResponseEntity.ok(usuarios);
    }
    //GET BY Nombre
    @GetMapping("/{nombre}")
    @Cacheable
    public ResponseEntity<Usuario> findByNombre(@PathVariable String nombre) {
        Usuario u = this.usuarioRepository.findByNombre(nombre);
        return ResponseEntity.ok(u);
    }
    //INSERT
    @PostMapping("/usuario")
    public ResponseEntity<Usuario>addUsuario( @Valid @RequestBody Usuario usuario  ) {
        this.usuarioRepository.save(usuario);
        return ResponseEntity.created(null).body(usuario);
    }
    //UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@Valid @RequestBody Usuario usuario, @PathVariable int id) {
        Usuario persistido = usuarioRepository.save(usuario);
        return ResponseEntity.ok().body(persistido);
    }
    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUsuario(@PathVariable int id) {
        usuarioRepository.deleteById(id);
        String mensaje = "Usuario con id " + id + " eliminado";
        return ResponseEntity.ok().body(mensaje);
    }
}
