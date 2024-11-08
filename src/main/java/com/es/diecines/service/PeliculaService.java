package com.es.diecines.service;

import com.es.diecines.dto.PeliculaDTO;
import com.es.diecines.error.BaseDeDatosException;
import com.es.diecines.model.Pelicula;
import com.es.diecines.repository.PeliculaRepository;
import com.es.diecines.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.es.diecines.exceptions.NotFoundException;


@Service
public class PeliculaService {

    @Autowired
    private PeliculaRepository peliculaRepository;

    public PeliculaDTO getById(String id) {

        // 1 Aplicamos la logica de negocio
        // -> El id debe ser Long
        Long idL = 0L;
        try {
            idL = Long.parseLong(id);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("El formato del id es incorrecto");
        }

        // 2 obtenemos la Pelicula
        Pelicula p = null;
        try {
            p = peliculaRepository
                    .findById(idL)
                    .orElse(null);
        } catch (Exception e) {
            throw new BaseDeDatosException(idL + " erróneo");
        }

        if(p == null) {
            throw new NotFoundException("id "+id+" no encontrado");
        } else {
            // 3 Convertir p (Pelicula) a PeliculaDTO
            return Mapper.entityToDTO(p);
        }
    }
}
