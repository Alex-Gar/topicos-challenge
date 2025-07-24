package com.topicos.topicos.services;

import org.springframework.data.domain.Pageable;

import com.topicos.topicos.models.dtos.UsuarioRequestDto;
import com.topicos.topicos.models.payload.ApiResponse;

public interface UsuarioService {

    ApiResponse guardarUsuario(UsuarioRequestDto usuarioDto);

    ApiResponse listarUsuarios(Pageable pageable);

    ApiResponse obtenerUsusarioPorId(Long id);

    ApiResponse eliminarUsusario(Long id);

    ApiResponse actualizarUsusario(Long id, UsuarioRequestDto usuarioDto);

}
