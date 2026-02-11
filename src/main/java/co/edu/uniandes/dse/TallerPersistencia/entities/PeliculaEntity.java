package co.edu.uniandes.dse.TallerPersistencia.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class PeliculaEntity extends BaseEntity {

    private Long id;
    private String titulo;
    private Integer anioLanzamiento;

    @ManyToMany
    @JoinTable(name = "pelicula_actor", joinColumns = @jakarta.persistence.JoinColumn(name = "pelicula_id"), inverseJoinColumns = @jakarta.persistence.JoinColumn(name = "actor_id"))
    private java.util.List<ActorEntity> actores;

    @ManyToOne
    private DirectorEntity director;
    
}
