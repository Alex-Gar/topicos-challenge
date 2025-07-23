package com.topicos.topicos.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.topicos.topicos.models.entities.Topico;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {

}
