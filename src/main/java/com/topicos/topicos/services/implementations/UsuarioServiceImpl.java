package com.topicos.topicos.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.topicos.topicos.exceptions.ResourceNotFoundException;
import com.topicos.topicos.models.dtos.UsuarioRequestDto;
import com.topicos.topicos.models.dtos.UsuarioResponseDto;
import com.topicos.topicos.models.entities.Usuario;
import com.topicos.topicos.models.payload.ApiResponse;
import com.topicos.topicos.models.repositories.UsuarioRepository;
import com.topicos.topicos.services.FuncionesGenericasService;
import com.topicos.topicos.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private FuncionesGenericasService funcionGenericaService;

    @Override
    @Transactional
    public ApiResponse guardarUsuario(UsuarioRequestDto usuarioDto) {
        Usuario usuario = this.usuarioRepository.save(new Usuario(usuarioDto));
        UsuarioResponseDto usuarioCreado = new UsuarioResponseDto(usuario);
        return new ApiResponse("Usuario guardado correctamente", true, usuarioCreado);
    }

    @Override
    @Transactional(readOnly = true)
    public ApiResponse listarUsuarios(Pageable pageable) {
        Page<UsuarioResponseDto> listaUsuarios = this.usuarioRepository.findAll(pageable)
                .map(usuario -> new UsuarioResponseDto(usuario));

        if (listaUsuarios.isEmpty()) {
            throw new ResourceNotFoundException("Usuarios");
        }
        return new ApiResponse("Usuarios listados correctamente", true, listaUsuarios);
    }

    @Override
    @Transactional(readOnly = true)
    public ApiResponse obtenerUsusarioPorId(Long id) {
        UsuarioResponseDto usuarioDto = this.usuarioRepository.findById(id).map(u -> new UsuarioResponseDto(u))
                .orElseThrow(() -> new ResourceNotFoundException("Usuario", "id", id));

        ApiResponse response = new ApiResponse("Usuario buscado correctamente", true, usuarioDto);
        return response;
    }

    @Override
    @Transactional
    public ApiResponse eliminarUsusario(Long id) {
        funcionGenericaService.existeId(id, this.usuarioRepository, "Usuario");
        usuarioRepository.deleteById(id);
        return new ApiResponse("Usuario eliminado correctamente", true, null);
    }

    @Override
    @Transactional
    public ApiResponse actualizarUsusario(Long id, UsuarioRequestDto usuarioDto) {
        funcionGenericaService.existeId(id, this.usuarioRepository, "Usuario");
        Usuario usuario = funcionGenericaService.referenciaPorId(id, this.usuarioRepository, "usuario");
        usuario.actualizarDatos(usuarioDto);
        UsuarioResponseDto usuarioDtoActualizado = new UsuarioResponseDto(usuario);

        return new ApiResponse("Usuario actualizado correctamente", true, usuarioDtoActualizado);
    }

}
