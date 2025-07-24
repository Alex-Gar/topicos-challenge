package com.topicos.topicos.models.dtos.topicos;

import java.time.LocalDateTime;

import com.topicos.topicos.models.entities.Topico;

public record TopicoInternalDto(
        String titulo,
        String mensaje,
        Long usuarioId,
        LocalDateTime fechaCreacion,
        Long cursoId) {

    public TopicoInternalDto(Topico topico) {
        this(
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getUsuario() != null ? topico.getUsuario().getId() : null,
                topico.getFechaCreacion(),
                topico.getCurso() != null ? topico.getCurso().getId() : null);
    }

}
