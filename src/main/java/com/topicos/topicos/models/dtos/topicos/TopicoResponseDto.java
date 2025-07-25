package com.topicos.topicos.models.dtos.topicos;

import java.time.LocalDateTime;

import com.topicos.topicos.models.dtos.cursos.CursoRequestDto;
import com.topicos.topicos.models.dtos.usuarios.UsuarioInternalDto;
import com.topicos.topicos.models.entities.Topico;

public record TopicoResponseDto(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        UsuarioInternalDto usuario,
        CursoRequestDto curso) {

    public TopicoResponseDto(Topico topico) {
        this(topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                new UsuarioInternalDto(topico.getUsuario().getId(), topico.getUsuario().getNombre(), topico.getUsuario().getEmail()),
                new CursoRequestDto(topico.getCurso().getId(), topico.getCurso().getNombre(), topico.getCurso().getCategoria()));
    }
}
