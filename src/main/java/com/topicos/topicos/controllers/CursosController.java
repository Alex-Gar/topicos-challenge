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

import com.topicos.topicos.models.dtos.cursos.CursoRequestDto;
import com.topicos.topicos.models.payload.ApiResponse;
import com.topicos.topicos.services.CursoService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@SecurityRequirement(name = "bearer-key")
@RestController
@RequestMapping("cursos")
public class CursosController {

    @Autowired
    private CursoService cursoService;

    @PostMapping
    public ResponseEntity<ApiResponse> crearCurso(@RequestBody @Valid CursoRequestDto cursoDto) {
        ApiResponse response = cursoService.guardarCurso(cursoDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ApiResponse> listarCursos(@PageableDefault(10) Pageable paginacion) {
        ApiResponse response = cursoService.listarCursos(paginacion);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> obtenerCursoPorId(@PathVariable Long id) {
        ApiResponse response = this.cursoService.obtenerCursoPorId(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> eliminarCurso(@PathVariable Long id) {
        ApiResponse response = this.cursoService.eliminarCurso(id);
        return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> actualizarCurso(@PathVariable Long id, @RequestBody @Valid CursoRequestDto cursoDto) {
        ApiResponse response = this.cursoService.actualizarCurso(id, cursoDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
