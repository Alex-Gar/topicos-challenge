package com.topicos.topicos.services;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionesGenericasService {
    boolean existeId(Long id, JpaRepository<?, Long> repository, String tipo);

    <T> T referenciaPorId(Long id, JpaRepository<T, Long> repository, String tipo);
}
