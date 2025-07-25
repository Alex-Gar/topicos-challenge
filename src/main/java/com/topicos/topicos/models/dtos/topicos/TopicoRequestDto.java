package com.topicos.topicos.models.dtos.topicos;

import com.topicos.topicos.models.entities.Topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TopicoRequestDto(
        @NotBlank String titulo,
        @NotBlank String mensaje,
        @NotNull Long usuarioId,
        @NotNull Long cursoId) {

    public TopicoRequestDto(Topico topico) {
        this(topico.getTitulo(),
                topico.getMensaje(),
                topico.getUsuario() != null ? topico.getUsuario().getId() : null,
                topico.getCurso() != null ? topico.getCurso().getId() : null);
    }
}
