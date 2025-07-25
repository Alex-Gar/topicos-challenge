package com.topicos.topicos.models.dtos.usuarios;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.topicos.topicos.models.dtos.cursos.CursoRequestDto;
import com.topicos.topicos.models.dtos.topicos.TopicoInternal2Dto;
import com.topicos.topicos.models.entities.Usuario;

public record UsuarioIntenal2Dto(
                Long id,
                String nombre,
                String email,
                List<TopicoInternal2Dto> topicos) {

        public UsuarioIntenal2Dto(Usuario usuario) {
                this(
                                usuario.getId(),
                                usuario.getNombre(),
                                usuario.getEmail(),
                                usuario.getTopicos() != null ? usuario.getTopicos().stream()
                                                .map(t -> new TopicoInternal2Dto(
                                                                t.getId(),
                                                                t.getTitulo(),
                                                                t.getMensaje(),
                                                                new CursoRequestDto(t.getCurso().getId(),
                                                                                t.getCurso().getNombre(),
                                                                                t.getCurso().getCategoria())

                                                )).collect(Collectors.toList()) : Collections.emptyList()

                );
        }
}