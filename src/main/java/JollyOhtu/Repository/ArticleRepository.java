package JollyOhtu.Repository;

import JollyOhtu.Objects.Article;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Arttu
 */
public interface ArticleRepository extends CrudRepository<Article, Long> {

    List<Article> findByTitle(String title);
}
