package com.topicos.topicos.services.implementations;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.topicos.topicos.exceptions.ResourceNotFoundException;
import com.topicos.topicos.services.FuncionesGenericasService;

@Service
public class FuncionesGenericasServiceImpl implements FuncionesGenericasService {

    @Override
    public boolean existeId(Long id, JpaRepository<?, Long> repository, String tipo) {
        boolean existe = repository.existsById(id);

        if (existe == false) {
            throw new ResourceNotFoundException(tipo, "id", id);
        }

        return existe;
    }

    @Override
    public <T> T referenciaPorId(Long id, JpaRepository<T, Long> repository, String tipo) {
        T referencia = repository.getReferenceById(id);

        return referencia;
    }

}
