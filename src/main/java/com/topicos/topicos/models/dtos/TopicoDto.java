package com.topicos.topicos.models.dtos;

import java.time.LocalDateTime;

import com.topicos.topicos.models.entities.Topico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TopicoDto(
                Long id,
                @NotBlank String titulo,
                @NotBlank String mensaje,
                @Valid @NotNull UsuarioDto usuario,
                @NotBlank LocalDateTime fechaCreacion,
                @NotNull Boolean status,
                @Valid @NotNull CursoDto curso) {

        public TopicoDto(Topico topico) {
                this(
                                topico.getId(),
                                topico.getTitulo(),
                                topico.getMensaje(),
                                topico.getUsuario() != null ? new UsuarioDto(topico.getUsuario()) : null,
                                topico.getFechaCreacion(),
                                topico.isStatus(),
                                topico.getCurso() != null ? new CursoDto(topico.getCurso()) : null);
        }

}
