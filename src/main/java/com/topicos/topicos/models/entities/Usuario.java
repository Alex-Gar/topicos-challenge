package com.topicos.topicos.models.entities;

import java.util.ArrayList;
import java.util.List;

import com.topicos.topicos.models.dtos.UsuarioRequestDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String email;

    private String password;

    @OneToMany(mappedBy = "usuario")
    private List<Topico> topicos = new ArrayList<>();

    public Usuario() {
    }

    public Usuario(UsuarioRequestDto usuarioDto) {
        this.id = usuarioDto.id();
        this.nombre = usuarioDto.nombre();
        this.email = usuarioDto.email();
        this.password = usuarioDto.password();
    }

    public void actualizarDatos(UsuarioRequestDto usuarioDto) {
        if (usuarioDto.nombre() != null) {
            this.nombre = usuarioDto.nombre();
        }
        if (usuarioDto.email() != null) {
            this.email = usuarioDto.email();
        }
        if (usuarioDto.password() != null) {
            this.password = usuarioDto.password();
        }
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<Topico> getTopicos() {
        return topicos;
    }

}
