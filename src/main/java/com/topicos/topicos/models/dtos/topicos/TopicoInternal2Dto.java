package com.topicos.topicos.models.dtos.topicos;

import com.topicos.topicos.models.dtos.cursos.CursoRequestDto;
import com.topicos.topicos.models.entities.Topico;

public record TopicoInternal2Dto(
        Long id,
        String titulo,
        String mensaje,
        CursoRequestDto curso) {
    public TopicoInternal2Dto(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getCurso() != null ? new CursoRequestDto(topico.getCurso()) : null);

    }

}
