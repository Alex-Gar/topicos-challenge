package com.topicos.topicos.models.dtos;

import java.util.List;

import com.topicos.topicos.models.entities.Usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioDto(
                Long id,
                @NotBlank String nombre,
                @Email String email,
                @NotBlank String password,
                List<TopicoDto> topicos) {

        public UsuarioDto(Usuario usuario) {
                this(
                                usuario.getId(),
                                usuario.getNombre(),
                                usuario.getEmail(),
                                usuario.getPassword(),
                                usuario.getTopicos() == null ? List.of()
                                                : usuario.getTopicos().stream().map(TopicoDto::new).toList()

                );
        }

}
