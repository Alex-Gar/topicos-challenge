package com.topicos.topicos.models.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.topicos.topicos.models.entities.Topico;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {

    Page<Topico> findAllByStatusTrueOrderByFechaCreacionAsc(Pageable pageable);

    @Query("""
                SELECT t FROM Topico t
                WHERE t.id = :id AND t.status = true
            """)
    Optional<Topico> findByIdAndStatusTrue(@Param("id") Long id);

    @Query("""
            SELECT t From Topico t
            WHERE t.titulo = :titulo AND t.mensaje = :mensaje AND t.status = true
                """)
    List<Topico> findByTituloAndMensajeAndStatusTrue(@Param("titulo") String titulo, @Param("mensaje") String mensaje);
}
