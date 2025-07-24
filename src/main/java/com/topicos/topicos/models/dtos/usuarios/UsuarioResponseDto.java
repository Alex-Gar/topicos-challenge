package com.topicos.topicos.models.dtos.usuarios;

import java.util.List;

import com.topicos.topicos.models.dtos.cursos.CursoRequestDto;
import com.topicos.topicos.models.dtos.topicos.TopicoResponseDto;
import com.topicos.topicos.models.entities.Usuario;

public record UsuarioResponseDto(
                Long id,
                String nombre,
                String email,
                String password,
                List<TopicoResponseDto> topicos) {

        public UsuarioResponseDto(Usuario usuario) {
                this(
                                usuario.getId(),
                                usuario.getNombre(),
                                usuario.getEmail(),
                                usuario.getPassword(),
                                usuario.getTopicos() == null ? List.of()
                                                : usuario.getTopicos().stream()
                                                                .map(u -> new TopicoResponseDto(
                                                                                u.getId(),
                                                                                u.getTitulo(),
                                                                                u.getMensaje(),
                                                                                new UsuarioInternalDto(
                                                                                                u.getId(),
                                                                                                u.getUsuario().getNombre(),
                                                                                                u.getUsuario().getEmail()),
                                                                                new CursoRequestDto(
                                                                                                u.getId(),
                                                                                                u.getCurso().getNombre(),
                                                                                                u.getCurso().getCategoria())))
                                                                .toList());
        }

}
