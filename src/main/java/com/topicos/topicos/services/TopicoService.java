package com.topicos.topicos.services;

import java.util.List;
import org.springframework.data.domain.Page;
import com.topicos.topicos.models.dtos.TopicoDto;

public interface TopicoService {

    TopicoDto guardarTopico(TopicoDto topicoDto);

    List<Page<TopicoDto>> listarCursos();

    TopicoDto obtenerTopicoPorId(Long id);

    void eliminarTopico(Long id);

    TopicoDto actualizarTopico(Long id, TopicoDto topicoDto);

}
