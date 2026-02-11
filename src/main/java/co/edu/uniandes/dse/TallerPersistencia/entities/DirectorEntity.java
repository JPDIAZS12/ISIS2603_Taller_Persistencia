package co.edu.uniandes.dse.TallerPersistencia.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class DirectorEntity extends BaseEntity {

    private Long id;
    private String nombre;
    private String biografia;

    @OneToMany(mappedBy = "director")
    private java.util.List<PeliculaEntity> peliculas;

    
}
