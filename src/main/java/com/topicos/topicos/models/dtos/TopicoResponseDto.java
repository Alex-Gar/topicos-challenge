package com.topicos.topicos.models.dtos;

import com.topicos.topicos.models.entities.Topico;

public class TopicoResponseDto {

    Long id;
    String titulo;
    String mensaje;
    UsuarioRequestDto usuario;
    CursoRequestDto curso;

    public TopicoResponseDto() {
    }

    public TopicoResponseDto(Long id, String titulo, String mensaje, UsuarioRequestDto usuario,
            CursoRequestDto curso) {
        this.id = id;
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.usuario = usuario;
        this.curso = curso;
    }
    public TopicoResponseDto(Topico topico) {
        this.id = topico.getId();
        this.titulo = topico.getTitulo();
        this.mensaje = topico.getMensaje();
        // this.usuario = topico.getUsuario();
        // this.curso = curso;
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

    public UsuarioRequestDto getUsuario() {
        return usuario;
    }

    public CursoRequestDto getCurso() {
        return curso;
    }

}
