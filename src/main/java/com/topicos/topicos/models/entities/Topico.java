package com.topicos.topicos.models.entities;

import java.time.LocalDateTime;

import com.topicos.topicos.models.dtos.TopicoDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "topico")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    private Boolean status;
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;

    public Topico() {
    }

    public Topico(Long id, String titulo, String mensaje, LocalDateTime fechaCreacion, Boolean activo, Usuario usuario,
            Curso curso) {
        this.id = id;
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.fechaCreacion = fechaCreacion;
        this.status = status;
        this.usuario = usuario;
        this.curso = curso;
    }

    public Topico(TopicoDto topicoDto) {
        this.id = topicoDto.id();
        this.titulo = topicoDto.titulo();
        this.mensaje = topicoDto.mensaje();
        this.fechaCreacion = topicoDto.fechaCreacion();
        this.status = topicoDto.status();
        this.usuario = topicoDto.usuario() != null ? new Usuario(topicoDto.usuario()) : null;
        this.curso = topicoDto.curso() != null ? new Curso(topicoDto.curso()) : null;
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

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public Boolean isStatus() {
        return status;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Curso getCurso() {
        return curso;
    }

}
