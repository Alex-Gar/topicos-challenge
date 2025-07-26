package com.topicos.topicos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.topicos.topicos.models.dtos.usuarios.UsuarioRequestDto;
import com.topicos.topicos.models.payload.ApiResponse;
import com.topicos.topicos.services.UsuarioService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@SecurityRequirement(name = "bearer-key")
@RestController
@RequestMapping("/usuario")
public class UsuariosController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<ApiResponse> guardarUsuario(@RequestBody @Valid UsuarioRequestDto usuarioDto) {
        ApiResponse response = this.usuarioService.guardarUsuario(usuarioDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ApiResponse> listarUsuarios(@PageableDefault(size = 10) Pageable paginacion) {
        ApiResponse response = this.usuarioService.listarUsuarios(paginacion);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> buscarId(@PathVariable Long id) {
        ApiResponse response = this.usuarioService.obtenerUsusarioPorId(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> eliminarUsuario(@PathVariable Long id) {
        ApiResponse response = this.usuarioService.eliminarUsusario(id);
        return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> actualizarUsuario(@PathVariable Long id,
            @RequestBody @Valid UsuarioRequestDto usuarioDto) {
                
        ApiResponse response = this.usuarioService.actualizarUsusario(id, usuarioDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
