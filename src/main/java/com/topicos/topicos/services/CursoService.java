package com.topicos.topicos.services;

import org.springframework.data.domain.Pageable;

import com.topicos.topicos.models.dtos.cursos.CursoRequestDto;
import com.topicos.topicos.models.payload.ApiResponse;

public interface CursoService {

    ApiResponse guardarCurso(CursoRequestDto cursoDto);

    ApiResponse listarCursos(Pageable pageable);

    ApiResponse obtenerCursoPorId(Long id);

    ApiResponse eliminarCurso(Long id);

    ApiResponse actualizarCurso(Long id, CursoRequestDto cursoDto);

}
