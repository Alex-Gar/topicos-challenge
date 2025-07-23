package com.topicos.topicos.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.topicos.topicos.exceptions.ResourceNotFoundException;
import com.topicos.topicos.models.dtos.TopicoDto;
import com.topicos.topicos.models.dtos.UsuarioDto;
import com.topicos.topicos.models.entities.Usuario;
import com.topicos.topicos.models.payload.ApiResponse;
import com.topicos.topicos.models.repositories.UsuarioRepository;
import com.topicos.topicos.services.FuncionesGenericasService;
import com.topicos.topicos.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final FuncionesGenericasServiceImpl funcionesGenericasServiceImpl;

    @Autowired
    private UsuarioRepository usuarioRepository;

    UsuarioServiceImpl(FuncionesGenericasServiceImpl funcionesGenericasServiceImpl) {
        this.funcionesGenericasServiceImpl = funcionesGenericasServiceImpl;
    }

    @Override
    @Transactional
    public ApiResponse guardarUsuario(UsuarioDto usuarioDto) {
        Usuario usuario = this.usuarioRepository.save(new Usuario(usuarioDto));

        UsuarioDto usuarioCreado = new UsuarioDto(usuario);
        return new ApiResponse("Usuario guardado correctamente", true, usuarioCreado);
    }

    @Override
    @Transactional(readOnly = true)
    public ApiResponse listarUsuarios(Pageable pageable) {

        Page<UsuarioDto> listaUsuarios = this.usuarioRepository.findAll(pageable)
                .map(usuario -> new UsuarioDto(
                        usuario.getId(),
                        usuario.getNombre(),
                        usuario.getEmail(),
                        usuario.getPassword(),
                        usuario.getTopicos().stream()
                                .map(TopicoDto::new)
                                .toList()));

        if (listaUsuarios.isEmpty()) {
            throw new ResourceNotFoundException("Usuarios");
        }
        return new ApiResponse("Usuarios listados correctamente", true, listaUsuarios);
    }

    @Override
    @Transactional(readOnly = true)
    public ApiResponse obtenerUsusarioPorId(Long id) {
        FuncionesGenericasService funcionGenericaService = new FuncionesGenericasServiceImpl();
        funcionGenericaService.existeId(id, this.usuarioRepository, "Usuario");

        UsuarioDto usuarioDto = this.usuarioRepository.findById(id).map(u -> new UsuarioDto(u))
                .orElseThrow(() -> new ResourceNotFoundException("Usuario", "id", id));

        ApiResponse response = new ApiResponse("Usuario buscado correctamente", true, usuarioDto);
        return response;
    }

    @Override
    @Transactional
    public ApiResponse eliminarUsusario(Long id) {
        FuncionesGenericasService funcionGenericaService = new FuncionesGenericasServiceImpl();
        funcionGenericaService.existeId(id, this.usuarioRepository, "Usuario");
        usuarioRepository.deleteById(id);

        return new ApiResponse("Usuario eliminado correctamente", true, null);
    }

    @Override
    @Transactional
    public ApiResponse actualizarUsusario(Long id, UsuarioDto usuarioDto) {
        FuncionesGenericasService funcionGenericaService = new FuncionesGenericasServiceImpl();
        Usuario usuario = funcionGenericaService.referenciaPorId(id, this.usuarioRepository, "usuario");
        usuario.actualizarDatos(usuarioDto);

        UsuarioDto usuarioDtoActualizado = new UsuarioDto(usuario);
        ApiResponse response = new ApiResponse("Usuario actualizado correctamente", true, usuarioDtoActualizado);
        return response;
    }

}
