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

    @Query("SELECT callId FROM Article a where a.author = :#{#article.author} and"
            + " a.title=:#{#article.title} and"
            + " a.journal=:#{#article.journal} and"
            + " a.year =:#{#article.year} and"
            + " a.volume =:#{#article.volume} and"
            + " a.number =:#{#article.number} and"
            + " a.pages =:#{#article.pages} and"
            + " a.month =:#{#article.month} and"
            + " a.note =:#{#article.note}")
    public List<String> findCallId(@Param("article") Article article);

    @Query("select case when count(a) > 0 then 'true' else 'false' end"
            + " from Article a where a.callId = :#{#article.callId}")
    public boolean callIdExists1(@Param("article") Article article);
    
    @Query("select case when count(b) > 0 then 'true' else 'false' end"
            + " from Book b where b.callId = :#{#article.callId}")
    public boolean callIdExists2(@Param("article")Article article);

    @Query("select case when count(i) > 0 then 'true' else 'false' end"
            + " from Inproceedings i where i.callId = :#{#article.callId}")
    public boolean callIdExists3(@Param("article")Article article);

    @Query("select a from Article a where"
            + " a.callId like concat('%', :word, '%') or"
            + " a.author like concat('%', :word, '%') or"
            + " a.title like concat('%', :word, '%') or"
            + " a.journal like concat('%', :word, '%') or"
            + " a.year like concat('%', :word, '%')  or"
            + " a.volume like concat('%', :word, '%') or"
            + " a.number like concat('%', :word, '%') or"
            + " a.pages like concat('%', :word, '%') or"
            + " a.month like concat('%', :word, '%') or"
            + " a.note like concat('%', :word, '%')")
    public List<Article> findWord(@Param("word") String word);
    
    
     
    
}
