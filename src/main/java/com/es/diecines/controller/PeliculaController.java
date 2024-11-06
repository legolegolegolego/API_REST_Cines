package com.es.diecines.controller;

import com.es.diecines.dto.PeliculaDTO;
import com.es.diecines.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    /**
     * Crear una pelicula
     * @return
     */
    public PeliculaDTO insert() {
        return null;
    }

    /**
     * Consultar todas las peliculas
     * @return
     */
    public List<PeliculaDTO> getAll() {
        return null;
    }

    /**
     * Consultar una pelicula por su ID
      * @return
     */
    @GetMapping("/{id}")
    public PeliculaDTO getById(
            @PathVariable String id
    ) {
        // 1 Comprobar que el id no viene vacío
        if (id == null || id.isEmpty()) return null;

        // 2 Si no viene vacio, llamo al Service
        PeliculaDTO p = peliculaService.getById(id);

        // 3 Compruebo la validez de p para devolver una respuesta
        if(p == null) {
            return null;
        } else {
            return p;
        }
    }


}
