package com.topicos.topicos.models.dtos;

import java.time.LocalDateTime;

import com.topicos.topicos.models.entities.Topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TopicoRequestDto(
        @NotBlank String titulo,
        @NotBlank String mensaje,
        @NotNull Long usuarioId,
        @NotNull LocalDateTime fechaCreacion,
        @NotNull Boolean status,
        @NotNull Long cursoId) {

    public TopicoRequestDto(Topico topico) {
        this(topico.getTitulo(),
                topico.getMensaje(),
                topico.getUsuario() != null ? topico.getUsuario().getId() : null,
                topico.getFechaCreacion(),
                topico.isStatus(), topico.getCurso() != null ? topico.getCurso().getId() : null);

    }
}
