package com.es.diecines.service;

import com.es.diecines.controller.PeliculaController;
import com.es.diecines.dto.PeliculaDTO;
import com.es.diecines.model.Pelicula;
import com.es.diecines.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            e.printStackTrace();
            return null;
        }

        // 2 obtenemos la Pelicula
        Pelicula p = peliculaRepository
                .findById(idL)
                .orElse(null);

        if(p == null) {
            return null;
        } else {
            // 3 Convertir p (Pelicula) a PeliculaDTO
            PeliculaDTO pDto = new PeliculaDTO();
            pDto.setDirector(p.getDirector());
            pDto.setId(p.getId());
            pDto.setRating(p.getRating());
            pDto.setSynopsis(p.getSynopsis());
            pDto.setTime(p.getTime());
            pDto.setScreenshot(p.getScreenshot());
            pDto.setPosterImage(p.getPosterImage());
            pDto.setTrailer(p.getTrailer());
            pDto.setTitle(p.getTitle());
            return pDto;
        }


    }
}
