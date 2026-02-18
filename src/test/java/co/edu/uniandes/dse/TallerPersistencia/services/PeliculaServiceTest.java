package co.edu.uniandes.dse.TallerPersistencia.services;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import jakarta.transaction.Transactional;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;
import co.edu.uniandes.dse.TallerPersistencia.entities.DirectorEntity;
import co.edu.uniandes.dse.TallerPersistencia.entities.PeliculaEntity;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;




@ExtendWith(SpringExtension.class)
@DataJpaTest
@Transactional
@Import(PeliculaService.class)
public class PeliculaServiceTest {

    @Autowired
    private PeliculaService peliculaService;

    @Autowired
    private TestEntityManager entityManager;

    private PodamFactory factory = new PodamFactoryImpl();

    @Test
    public void testCrearPelicula() {
        PeliculaEntity pelicula = factory.manufacturePojo(PeliculaEntity.class);

        DirectorEntity director = factory.manufacturePojo(DirectorEntity.class);  

        entityManager.persist(director); 
        entityManager.flush();  

        pelicula.setTitulo("Pelicula de prueba");
        pelicula.setDirector(director);

        PeliculaEntity result = peliculaService.crearPelicula(pelicula);
        PeliculaEntity entity = entityManager.find(PeliculaEntity.class, result.getId());
        assertNotNull(result);
        assertNotNull(entity);
        assertTrue(entity.getTitulo().equals("Pelicula de prueba"));
        assertTrue(entity.getDirector().getId().equals(director.getId()));
    }

    @Test 
    public void testDatosCorrectos(){
        PeliculaEntity pelicula = factory.manufacturePojo(PeliculaEntity.class);
        pelicula.setTitulo("Pelicula de prueba");
        pelicula.setAnioLanzamiento(2000);
        PeliculaEntity result = peliculaService.crearPelicula(pelicula);
        assertNotNull(result);
        assertTrue(result.getTitulo().equals("Pelicula de prueba"));
        assertTrue(result.getAnioLanzamiento() == 2000);
    }

    @Test
    public void anioLanzamientoInvalido() {
        PeliculaEntity pelicula = factory.manufacturePojo(PeliculaEntity.class);
        pelicula.setTitulo("Pelicula de prueba");
        pelicula.setAnioLanzamiento(1900);
        assertThrows(IllegalArgumentException.class, () -> {
            peliculaService.crearPelicula(pelicula);
        });
    }
    
}


