package com.topicos.topicos.models.dtos.cursos;

import java.util.List;

import com.topicos.topicos.models.dtos.Categoria;
import com.topicos.topicos.models.dtos.topicos.TopicoResponseDto;
import com.topicos.topicos.models.dtos.usuarios.UsuarioInternalDto;
import com.topicos.topicos.models.entities.Curso;

public record CursoResponseDto(
                Long id,
                String nombre,
                Categoria categoria,
                List<TopicoResponseDto> topicos) {

        public CursoResponseDto(Curso curso) {
                this(
                                curso.getId(),
                                curso.getNombre(),
                                curso.getCategoria(),
                                curso.getTopicos() == null ? List.of()
                                                : curso.getTopicos().stream()
                                                                .map(c -> new TopicoResponseDto(
                                                                                c.getId(),
                                                                                c.getTitulo(),
                                                                                c.getMensaje(),
                                                                                new UsuarioInternalDto(c.getId(), c
                                                                                                .getUsuario()
                                                                                                .getNombre(),
                                                                                                c.getUsuario().getEmail()),
                                                                                new CursoRequestDto(c.getId(), c
                                                                                                .getCurso().getNombre(),
                                                                                                c.getCurso().getCategoria())))
                                                                .toList());
        }

}
