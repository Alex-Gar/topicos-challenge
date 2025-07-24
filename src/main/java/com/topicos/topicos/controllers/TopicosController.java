package com.topicos.topicos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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

import com.topicos.topicos.models.dtos.TopicoRequestDto;
import com.topicos.topicos.models.payload.ApiResponse;
import com.topicos.topicos.services.TopicoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("topicos")
public class TopicosController {

    @Autowired
    private TopicoService topicoService;

    @PostMapping
    public ResponseEntity<ApiResponse> guardarTopico(@Valid @RequestBody TopicoRequestDto topicoDto) {
        ApiResponse response = this.topicoService.guardarTopico(topicoDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ApiResponse> listarTodo(Pageable pageable) {
        ApiResponse response = this.topicoService.listarTopicos(pageable);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse> buscarTopicoPorId(@PathVariable Long id) {
        ApiResponse response = this.topicoService.obtenerTopicoPorId(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponse> eliminarTopicoPorId(@PathVariable Long id) {
        ApiResponse response = this.topicoService.eliminarTopico(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<ApiResponse> actualizarTopico(@PathVariable Long id,
            @RequestBody TopicoRequestDto topicoRequest) {
        ApiResponse response = this.topicoService.actualizarTopico(id, topicoRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
