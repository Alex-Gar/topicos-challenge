package com.topicos.topicos.models.dtos.cursos;

import com.topicos.topicos.models.dtos.Categoria;
import com.topicos.topicos.models.entities.Curso;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CursoRequestDto(
        Long id,
        @NotBlank String nombre,
        @NotNull Categoria categoria) {

    public CursoRequestDto(Curso curso) {
        this(
                curso.getId(),
                curso.getNombre(),
                curso.getCategoria());
    }
}
