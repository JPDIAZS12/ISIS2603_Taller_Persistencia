package co.edu.uniandes.dse.TallerPersistencia.repositories;
import java.util.List;

import org.springframework.stereotype.Repository;
import co.edu.uniandes.dse.TallerPersistencia.entities.PeliculaEntity;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface PeliculaRepository extends JpaRepository<PeliculaEntity, Long> {
    List<PeliculaEntity> findByDirectorId(Long directorId);
    
}
