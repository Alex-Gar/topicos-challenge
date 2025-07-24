package com.topicos.topicos.models.dtos.usuarios;

import com.topicos.topicos.models.entities.Usuario;

public record UsuarioInternalDto(
        Long id,
        String nombre,
        String email
        // List<TopicoInternalDto> topicos
        ) {

    UsuarioInternalDto(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getEmail()
                // usuario.getTopicos() != null ? usuario.getTopicos().stream().map(TopicoInternalDto::new).collect(null(Collectors.toList())) : Collections.emptyList()
                );
    }
}
