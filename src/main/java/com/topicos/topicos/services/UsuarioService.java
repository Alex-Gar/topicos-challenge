package com.topicos.topicos.services;

import org.springframework.data.domain.Pageable;
import com.topicos.topicos.models.dtos.UsuarioDto;
import com.topicos.topicos.models.payload.ApiResponse;

public interface UsuarioService {

    ApiResponse guardarUsuario(UsuarioDto usuarioDto);

    ApiResponse listarUsuarios(Pageable pageable);

    ApiResponse obtenerUsusarioPorId(Long id);

    ApiResponse eliminarUsusario(Long id);

    ApiResponse actualizarUsusario(Long id, UsuarioDto usuarioDto);

}
