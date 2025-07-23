package com.topicos.topicos.services.implementations;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import com.topicos.topicos.models.dtos.CursoDto;
import com.topicos.topicos.models.repositories.CursoRepository;
import com.topicos.topicos.services.CursoService;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public CursoDto guardarCurso(CursoDto cursoDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'guardarCurso'");
    }

    @Override
    public List<Page<CursoDto>> listarCursos() {
        // List<Page<CursoDto>> listaCursos = cursoRepository.listarCursos();

        // if (listaCursos.isEmpty()) {
        // throw new ValidationException("No hay cursos disponibles");
        // }
        // return listaCursos;
        throw new UnsupportedOperationException("Unimplemented method 'obtenerCursoPorId'");
    }

    @Override
    public CursoDto obtenerCursoPorId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerCursoPorId'");
    }

    @Override
    public void eliminarCurso(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarCurso'");
    }

    @Override
    public CursoDto actualizarCurso(Long id, CursoDto cursoDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizarCurso'");
    }

}
