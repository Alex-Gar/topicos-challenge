package com.topicos.topicos.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.topicos.topicos.exceptions.ResourceNotFoundException;
import com.topicos.topicos.models.dtos.cursos.CursoRequestDto;
import com.topicos.topicos.models.dtos.cursos.CursoResponseDto;
import com.topicos.topicos.models.entities.Curso;
import com.topicos.topicos.models.payload.ApiResponse;
import com.topicos.topicos.models.repositories.CursoRepository;
import com.topicos.topicos.services.CursoService;
import com.topicos.topicos.services.FuncionesGenericasService;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private FuncionesGenericasService funcionGenericaService;

    @Override
    @Transactional
    public ApiResponse guardarCurso(CursoRequestDto cursoDto) {
        Curso curso = this.cursoRepository.save(new Curso(cursoDto));
        CursoResponseDto cursoCreado = new CursoResponseDto(curso);
        return new ApiResponse("Curso guardado exitosamente", true, cursoCreado);
    }

    @Override
    @Transactional(readOnly = true)
    public ApiResponse listarCursos(Pageable pageable) {
        Page<CursoResponseDto> listaCursos = this.cursoRepository.findAll(pageable).map(c -> new CursoResponseDto(c));

        if (listaCursos.isEmpty()) {
            throw new ResourceNotFoundException("Cursos");
        }
        return new ApiResponse("Cursos listados correctamente", true, listaCursos);
    }

    @Override
    public ApiResponse obtenerCursoPorId(Long id) {
        CursoResponseDto cursoDto = this.cursoRepository.findById(id).map(c -> new CursoResponseDto(c))
                .orElseThrow(() -> new ResourceNotFoundException("Curso", "id", id));

        return new ApiResponse("Curso buscado correctamente", true, cursoDto);
    }

    @Override
    public ApiResponse eliminarCurso(Long id) {
        this.funcionGenericaService.referenciaPorId(id, this.cursoRepository, "Curso");
        this.cursoRepository.deleteById(id);
        return new ApiResponse("Curso eliminado correctamente", true, null);
    }

    @Override
    public ApiResponse actualizarCurso(Long id, CursoRequestDto cursoDto) {
        this.funcionGenericaService.existeId(id, this.cursoRepository, "Curso");
        Curso curso = this.funcionGenericaService.referenciaPorId(id, this.cursoRepository, "Curso");
        curso.actualizarCurso(cursoDto);

        CursoResponseDto cursoActualizado = new CursoResponseDto(curso);
        return new ApiResponse("Curso actualizado correctamente", true, cursoActualizado);
    }

}
