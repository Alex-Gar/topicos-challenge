package com.topicos.topicos.services.implementations;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import com.topicos.topicos.models.dtos.TopicoDto;
import com.topicos.topicos.models.repositories.TopicoRepository;
import com.topicos.topicos.services.TopicoService;

@Service
public class TopicoServiceImpl implements TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Override
    public TopicoDto guardarTopico(TopicoDto topicoDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'guardarCurso'");
    }

    @Override
    public List<Page<TopicoDto>> listarCursos() {
        // List<Page<TopicoDto>> listaTopicos = topicoService.listarCursos();

        // if (listaTopicos.isEmpty()) {
        //     throw new ValidationException("No hay tópicos disponibles");
        // }
        // return listaTopicos;
        throw new UnsupportedOperationException("Unimplemented method 'obtenerCursoPorId'");
    }

    @Override
    public TopicoDto obtenerTopicoPorId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerCursoPorId'");
    }

    @Override
    public void eliminarTopico(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarCurso'");
    }

    @Override
    public TopicoDto actualizarTopico(Long id, TopicoDto topicoDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizarCurso'");
    }

}
