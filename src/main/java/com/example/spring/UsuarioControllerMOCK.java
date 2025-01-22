package com.example.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
