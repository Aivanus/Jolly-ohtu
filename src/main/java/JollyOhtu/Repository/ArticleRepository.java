package JollyOhtu.Repository;

import JollyOhtu.Objects.Article;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Arttu
 */
public interface ArticleRepository extends CrudRepository<Article, Long> {

    List<Article> findByTitle(String title);

    @Query("select case when count(a) > 0 then 'true' else 'false' end"
            + " from Article a where a.author = :#{#article.author} and"
            + " a.title=:#{#article.title} and"
            + " a.journal=:#{#article.journal} and"
            + " a.year =:#{#article.year} and"
            + " a.volume =:#{#article.volume} and"
            + " a.number =:#{#article.number} and"
            + " a.pages =:#{#article.pages} and"
            + " a.month =:#{#article.month} and"
            + " a.note =:#{#article.note}")
    boolean copyExists(@Param("article") Article article);
    
    
}
