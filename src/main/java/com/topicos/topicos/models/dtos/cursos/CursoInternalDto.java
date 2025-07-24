package com.topicos.topicos.models.dtos.cursos;

import java.util.List;

import com.topicos.topicos.models.dtos.Categoria;
import com.topicos.topicos.models.dtos.topicos.TopicoInternalDto;
import com.topicos.topicos.models.dtos.usuarios.UsuarioInternalDto;
import com.topicos.topicos.models.entities.Curso;

public record CursoInternalDto(
        Long id,
        String nombre,
        Categoria categoria,
        List<TopicoInternalDto> topicos) {

    public CursoInternalDto(Curso curso) {
        this(
                curso.getId(),
                curso.getNombre(),
                curso.getCategoria(),
                curso.getTopicos().stream().map(t -> new TopicoInternalDto(t.getTitulo(), t.getMensaje(),
                        new UsuarioInternalDto(t.getUsuario().getId(), t.getUsuario().getNombre(), t.getUsuario().getEmail())))
                        .toList());

    }

}
