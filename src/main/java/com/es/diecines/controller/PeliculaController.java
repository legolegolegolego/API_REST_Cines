package com.es.diecines.controller;

import com.es.diecines.dto.PeliculaDTO;
import com.es.diecines.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    /**
     * Crear una pelicula
     * El método para insertar es un POST -> @PostMapping
     * El recurso para este método es localhost:8080/peliculas/
     * /peliculas lo tenemos en el @RequestMapping arriba
     * / en el método sólo ponemos la barra
     *
     * La información de la nueva Pelicula viene en el cuerpo de la petición
     * Para obtener el cuerpo de la petición -> @RequestBody
     * @return
     */
    @PostMapping("/")
    public PeliculaDTO insert(
            @RequestBody PeliculaDTO pDto
    ) {

        // 1º Comprobar que pDto no es null

        // 2º LLamar al service, que es donde se hace la logica de negocio
        // y por donde se accede a la BDD

        // 3º Comprobar que lo que devuelve el service es null o no
        // y responder

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
