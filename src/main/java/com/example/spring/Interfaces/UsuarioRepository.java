package com.example.spring.Interfaces;

import com.example.spring.Clases.Usuario;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByNombre(@Size(max = 100) @NotNull String nombre);
}
