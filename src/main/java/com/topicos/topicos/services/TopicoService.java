package com.topicos.topicos.services;

import org.springframework.data.domain.Pageable;

import com.topicos.topicos.models.dtos.TopicoRequestDto;
import com.topicos.topicos.models.payload.ApiResponse;

public interface TopicoService {

    ApiResponse guardarTopico(TopicoRequestDto topicoDto);

    ApiResponse listarTopicos(Pageable pageable);

    ApiResponse obtenerTopicoPorId(Long id);

    ApiResponse eliminarTopico(Long id);

    ApiResponse actualizarTopico(Long id, TopicoRequestDto topicoDto);

}
