package JollyOhtu.Repository;

import JollyOhtu.Objects.Book;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Arttu
 */
public interface BookRepository extends CrudRepository<Book, Long> {

    List<Book> findByTitle(String title);
}
