package com.topicos.topicos.models.dtos.topicos;

import com.topicos.topicos.models.dtos.usuarios.UsuarioInternalDto;
import com.topicos.topicos.models.entities.Topico;

public record TopicoInternalDto(
                String titulo,
                String mensaje,
                UsuarioInternalDto usuario) {

        public TopicoInternalDto(Topico topico) {
                this(
                                topico.getTitulo(),
                                topico.getMensaje(),
                                topico.getUsuario() == null ? null
                                                : new UsuarioInternalDto(topico.getUsuario().getId(),
                                                                topico.getUsuario().getNombre(),
                                                                topico.getUsuario().getEmail()));
        }

}
