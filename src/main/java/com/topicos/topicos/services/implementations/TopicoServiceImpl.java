package com.topicos.topicos.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.topicos.topicos.exceptions.ResourceNotFoundException;
import com.topicos.topicos.models.dtos.CursoRequestDto;
import com.topicos.topicos.models.dtos.TopicoRequestDto;
import com.topicos.topicos.models.dtos.TopicoResponseDto;
import com.topicos.topicos.models.dtos.UsuarioRequestDto;
import com.topicos.topicos.models.dtos.UsuarioResponseDto;
import com.topicos.topicos.models.entities.Topico;
import com.topicos.topicos.models.payload.ApiResponse;
import com.topicos.topicos.models.repositories.CursoRepository;
import com.topicos.topicos.models.repositories.TopicoRepository;
import com.topicos.topicos.models.repositories.UsuarioRepository;
import com.topicos.topicos.services.FuncionesGenericasService;
import com.topicos.topicos.services.TopicoService;

@Service
public class TopicoServiceImpl implements TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private FuncionesGenericasService funcionesGenericasService;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    @Transactional
    public ApiResponse guardarTopico(TopicoRequestDto topicoDto) {
        Topico topico = this.topicoRepository.save(new Topico(
                topicoDto.titulo(),
                topicoDto.mensaje(),
                topicoDto.fechaCreacion(),
                topicoDto.status(),
                this.funcionesGenericasService.referenciaPorId(topicoDto.usuarioId(), this.usuarioRepository,
                        "usuario"),
                this.funcionesGenericasService.referenciaPorId(topicoDto.cursoId(), this.cursoRepository, "curso")));
        TopicoResponseDto nuevoTopico = new TopicoResponseDto(topico);
        return new ApiResponse("Topico creado exitosamente.", true, nuevoTopico);
    }

    @Override
    @Transactional(readOnly = true)
    public ApiResponse listarTopicos(Pageable pageable) {
        Page<TopicoResponseDto> listaTopicos = this.topicoRepository.findAllByAndStatusTrue(pageable)
                .map(t -> new TopicoResponseDto(t.getId(), t.getTitulo(), t.getMensaje(),
                        new UsuarioRequestDto(t.getId(), t.getUsuario().getNombre(),
                                t.getUsuario().getEmail(), t.getUsuario().getPassword()),
                        new CursoRequestDto(t.getId(), t.getCurso().getNombre(), t.getCurso().getCategoria())));
        if (listaTopicos.isEmpty()) {
            throw new ResourceNotFoundException("Topicos");
        }
        return new ApiResponse("Se listaron los topicos", true, listaTopicos);
    }

    @Override
    @Transactional(readOnly = true)
    public ApiResponse obtenerTopicoPorId(Long id) {
        TopicoResponseDto topico = this.topicoRepository
                .findByIdAndStatusTrue(id).map(t -> new TopicoResponseDto(t.getId(), t.getTitulo(), t.getMensaje(),
                        new UsuarioRequestDto(t.getId(), t.getUsuario().getNombre(),
                                t.getUsuario().getEmail(), t.getUsuario().getPassword()),
                        new CursoRequestDto(t.getId(), t.getCurso().getNombre(), t.getCurso().getCategoria())))
                .orElseThrow(() -> new ResourceNotFoundException("Topicos", "id", id));

        return new ApiResponse("Recurso encontrado correctamente", true, topico);
    }

    @Override
    @Transactional
    public ApiResponse eliminarTopico(Long id) {
        Topico topico = this.funcionesGenericasService.referenciaPorId(id, this.topicoRepository, "Topico");
        topico.eliminacionLogica();
        return new ApiResponse("Elemento eliminado correctamente.", true, id);
    }

    @Override
    @Transactional
    public ApiResponse actualizarTopico(Long id, TopicoRequestDto topicoDto) {
        Topico topico = this.funcionesGenericasService.referenciaPorId(id, this.topicoRepository, "Topico");
        topico.validaciones(topicoDto);

        TopicoResponseDto topicoResponse = new TopicoResponseDto(topico);
        return new ApiResponse("Elemento actualizado correctamente", true, topicoResponse);
    }

}
