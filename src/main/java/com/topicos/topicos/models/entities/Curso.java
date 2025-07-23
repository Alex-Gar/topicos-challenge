package com.topicos.topicos.models.entities;

import java.util.List;

import com.topicos.topicos.models.dtos.Categoria;
import com.topicos.topicos.models.dtos.CursoDto;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @OneToMany(mappedBy = "curso")
    private List<Topico> topicos;

    public Curso() {
    }

    public Curso(Long id, String nombre, Categoria categoria, List<Topico> topicos) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.topicos = topicos;
    }

    public Curso(CursoDto cursoDto) {
        this.id = cursoDto.id();
        this.nombre = cursoDto.nombre();
        this.categoria = cursoDto.categoria();
        this.topicos = cursoDto.topicos().stream()
                .map(Topico::new)
                .toList();
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public List<Topico> getTopicos() {
        return topicos;
    }

}
