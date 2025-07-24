package com.topicos.topicos.models.dtos;

import java.util.List;
import com.topicos.topicos.models.entities.Usuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioResponseDto(
                Long id,
                String nombre,
                @Email String email,
                @NotBlank String password,
                List<TopicoResponseDto> topicos) {

        public UsuarioResponseDto(Usuario usuario) {
                this(
                                usuario.getId(),
                                usuario.getNombre(),
                                usuario.getEmail(),
                                usuario.getPassword(),
                                usuario.getTopicos() == null ? List.of()
                                                : usuario.getTopicos().stream()
                                                                .map(u -> new TopicoResponseDto(u.getId(),
                                                                                u.getTitulo(), u.getMensaje()))
                                                                .toList());
        }

}
