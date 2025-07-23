package com.topicos.topicos.models.dtos;

import java.util.List;

import com.topicos.topicos.models.entities.Curso;

import jakarta.validation.constraints.NotBlank;

public record CursoDto(
        Long id,
        @NotBlank String nombre,
        @NotBlank Categoria categoria,
        List<TopicoDto> topicos) {

    public CursoDto(Curso curso) {
        this(
                curso.getId(),
                curso.getNombre(),
                curso.getCategoria(),
                curso.getTopicos().stream()
                        .map(TopicoDto::new)
                        .toList());
    }

}
