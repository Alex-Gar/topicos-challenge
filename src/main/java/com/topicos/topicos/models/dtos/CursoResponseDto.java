package com.topicos.topicos.models.dtos;

import java.util.List;

import com.topicos.topicos.models.entities.Curso;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CursoResponseDto(
                Long id,
                @NotBlank String nombre,
                @NotNull Categoria categoria,
                List<TopicoResponseDto> topicos) {

        public CursoResponseDto(Curso curso) {
                this(
                                curso.getId(),
                                curso.getNombre(),
                                curso.getCategoria(),
                                curso.getTopicos() == null ? List.of()
                                                : curso.getTopicos().stream()
                                                                .map(c -> new TopicoResponseDto(c.getId(),
                                                                                c.getTitulo(), c.getMensaje()))
                                                                .toList());
        }

}
