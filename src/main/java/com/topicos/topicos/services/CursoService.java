package com.topicos.topicos.services;

import java.util.List;
import org.springframework.data.domain.Page;
import com.topicos.topicos.models.dtos.CursoDto;

public interface CursoService {

    CursoDto guardarCurso(CursoDto cursoDto);

    List<Page<CursoDto>> listarCursos();

    CursoDto obtenerCursoPorId(Long id);

    void eliminarCurso(Long id);

    CursoDto actualizarCurso(Long id, CursoDto cursoDto);

}
