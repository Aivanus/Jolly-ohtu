package JollyOhtu.Repository;

import JollyOhtu.Objects.Proceeding;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Arttu
 */
public interface ProceedingRepository extends CrudRepository<Proceeding, Long> {

    List<Proceeding> findByTitle(String title);
}
