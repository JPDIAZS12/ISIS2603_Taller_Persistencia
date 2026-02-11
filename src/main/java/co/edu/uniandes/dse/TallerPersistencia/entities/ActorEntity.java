package co.edu.uniandes.dse.TallerPersistencia.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;


@Entity
@Data
public class ActorEntity extends BaseEntity {

    private Long id;
    private String nombre;
    private String nacionalidad;

    @ManyToMany(mappedBy = "actores")
    private java.util.List<PeliculaEntity> peliculas;
    
}
