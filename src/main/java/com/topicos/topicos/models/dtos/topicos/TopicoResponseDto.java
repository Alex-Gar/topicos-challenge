package com.topicos.topicos.models.dtos.topicos;

import com.topicos.topicos.models.dtos.cursos.CursoRequestDto;
import com.topicos.topicos.models.dtos.usuarios.UsuarioInternalDto;
import com.topicos.topicos.models.dtos.usuarios.UsuarioRequestDto;
import com.topicos.topicos.models.entities.Topico;

public class TopicoResponseDto {

    Long id;
    String titulo;
    String mensaje;
    // UsuarioRequestDto usuario;
    UsuarioInternalDto usuario;
    CursoRequestDto curso;

    public TopicoResponseDto() {
    }

    public TopicoResponseDto(Long id, String titulo, String mensaje, UsuarioRequestDto usuario,
            CursoRequestDto curso) {
        this.id = id;
        this.titulo = titulo;
        this.mensaje = mensaje;
        // this.usuario = usuario;
        this.curso = curso;
    }

    public TopicoResponseDto(Topico topico) {
        this.id = topico.getId();
        this.titulo = topico.getTitulo();
        this.mensaje = topico.getMensaje();
        this.usuario = new UsuarioInternalDto(topico.getId(), topico.getUsuario().getNombre(),
                topico.getUsuario().getEmail());
        this.curso = new CursoRequestDto(topico.getId(), topico.getCurso().getNombre(), topico.getCurso().getCategoria());
    }

    public TopicoResponseDto(Long id, String titulo, String mensaje) {
        this.id = id;
        this.titulo = titulo;
        this.mensaje = mensaje;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public UsuarioInternalDto getUsuario() {
        return usuario;
    }
    // public UsuarioRequestDto getUsuario() {
    //     return usuario;
    // }

    public CursoRequestDto getCurso() {
        return curso;
    }

}
