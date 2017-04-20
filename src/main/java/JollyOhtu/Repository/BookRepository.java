package JollyOhtu.Repository;

import JollyOhtu.Objects.Book;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Arttu
 */
public interface BookRepository extends CrudRepository<Book, Long> {
    
    @Query("select case when count(b) > 0 then 'true' else 'false' end"
            + " from Book b where b.title = :#{#book.title} and"
            + " b.year=:#{#book.year} and"
            + " b.publisher=:#{#book.publisher} and"
            + " b.author =:#{#book.author} and"
            + " b.volume =:#{#book.volume} and"
            + " b.series =:#{#book.series} and"
            + " b.address =:#{#book.address} and"
            + " b.note =:#{#book.note} and"
            + " b.month =:#{#book.month} and"
            + " b.edition =:#{#book.edition}")
    boolean copyExists(@Param("book") Book book);

    List<Book> findByTitle(String title);
}
