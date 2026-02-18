package co.edu.uniandes.dse.TallerPersistencia.services;

import org.springframework.beans.factory.annotation.Autowired;
import co.edu.uniandes.dse.TallerPersistencia.entities.PeliculaEntity;
import co.edu.uniandes.dse.TallerPersistencia.repositories.PeliculaRepository;  

public class PeliculaService {

    @Autowired
    private PeliculaRepository peliculaRepository;


    public PeliculaEntity crearPelicula(PeliculaEntity pelicula) {
        if (pelicula.getTitulo() == null || pelicula.getTitulo().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la película no puede ser vacío.");
        }
        
        if (peliculaRepository.findAll().stream().anyMatch(p -> p.getTitulo().equals(pelicula.getTitulo()))) {
            throw new IllegalArgumentException("Ya existe una película con el mismo nombre.");
        }
        
        if (pelicula.getAnioLanzamiento() == null || pelicula.getAnioLanzamiento() < 1930) {
            throw new IllegalArgumentException("El año de lanzamiento debe es inválido.");
        }
        
        return peliculaRepository.save(pelicula);
    }

    
}




