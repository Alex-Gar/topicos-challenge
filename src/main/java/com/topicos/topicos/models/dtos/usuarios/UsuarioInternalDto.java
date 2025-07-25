package com.topicos.topicos.models.dtos.usuarios;

import com.topicos.topicos.models.entities.Usuario;

public record UsuarioInternalDto(
        Long id,
        String nombre,
        String email) {

    public UsuarioInternalDto(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getEmail());
    }
}
