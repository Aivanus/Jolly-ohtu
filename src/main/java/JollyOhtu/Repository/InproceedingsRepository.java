package JollyOhtu.Repository;

import JollyOhtu.Objects.Inproceedings;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Arttu
 */
public interface InproceedingsRepository extends CrudRepository<Inproceedings, Long> {

    List<Inproceedings> findByTitle(String title);
}
