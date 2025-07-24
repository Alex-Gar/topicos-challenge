package com.topicos.topicos.models.dtos;

import com.topicos.topicos.models.entities.Usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioRequestDto(Long id, @NotBlank String nombre, @Email String email, @NotBlank String password) {

    public UsuarioRequestDto(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getEmail(),
                usuario.getPassword());
    }

}
