package com.topicos.topicos.models.validations.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.topicos.topicos.exceptions.ValidationException;
import com.topicos.topicos.models.dtos.topicos.TopicoRequestDto;
import com.topicos.topicos.models.entities.Topico;
import com.topicos.topicos.models.repositories.TopicoRepository;
import com.topicos.topicos.models.validations.Validaciones;

@Component
public class ValidarRegistrosDuplicados implements Validaciones {

    @Autowired
    private TopicoRepository topicoRepository;

    @Override
    public void validar(TopicoRequestDto topicoRequest) {
        List<Topico> validarTopico = this.topicoRepository
                .findByTituloAndMensajeAndStatusTrue(topicoRequest.titulo(), topicoRequest.mensaje());

        if (!validarTopico.isEmpty()) {
            throw new ValidationException("Ya existe un tópico con el mismo título y mensaje.");
        }
    }

}
