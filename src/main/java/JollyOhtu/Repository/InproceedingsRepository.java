package JollyOhtu.Repository;

import JollyOhtu.Objects.Inproceedings;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Arttu
 */
public interface InproceedingsRepository extends CrudRepository<Inproceedings, Long> {

    List<Inproceedings> findByTitle(String title);
    
    @Query("select case when count(i) > 0 then 'true' else 'false' end"
            + " from Inproceedings i where i.author = :#{#inpro.author} and"
            + " i.title = :#{#inpro.title} and"
            + " i.booktitle = :#{#inpro.booktitle} and"
            + " i.year = :#{#inpro.year} and"
            + " i.editor = :#{#inpro.editor} and"
            + " i.volumeNumber = :#{#inpro.volumeNumber} and"
            + " i.series = :#{#inpro.series} and"
            + " i.pages = :#{#inpro.pages} and"
            + " i.address = :#{#inpro.address} and"
            + " i.month = :#{#inpro.month} and"
            + " i.organization = :#{#inpro.organization} and"
            + " i.publisher = :#{#inpro.publisher} and"
            + " i.note = :#{#inpro.note}")
    boolean copyExists(@Param("inpro") Inproceedings inpro);

    @Query("select case when count(i) > 0 then 'true' else 'false' end"
            + " from Inproceedings i where i.callId = :#{#inpro.callId}")
    boolean callIdExists1(@Param("inpro") Inproceedings inpro);

    @Query("select case when count(a) > 0 then 'true' else 'false' end"
            + " from Article a where a.callId = :#{#inpro.callId}")
    boolean callIdExists2(@Param("inpro") Inproceedings inpro);
    
    @Query("select case when count(b) > 0 then 'true' else 'false' end"
            + " from Book b where b.callId = :#{#inpro.callId}")
    boolean callIdExists3(@Param("inpro") Inproceedings inpro);
    
    @Query("SELECT callId FROM Inproceedings i where i.author = :#{#inpro.author} and"
            + " i.title = :#{#inpro.title} and"
            + " i.booktitle = :#{#inpro.booktitle} and"
            + " i.year = :#{#inpro.year} and"
            + " i.editor = :#{#inpro.editor} and"
            + " i.volumeNumber = :#{#inpro.volumeNumber} and"
            + " i.series = :#{#inpro.series} and"
            + " i.pages = :#{#inpro.pages} and"
            + " i.address = :#{#inpro.address} and"
            + " i.month = :#{#inpro.month} and"
            + " i.organization = :#{#inpro.organization} and"
            + " i.publisher = :#{#inpro.publisher} and"
            + " i.note = :#{#inpro.note}")
    public List<String> findCallId(@Param("inpro") Inproceedings inpro);

    @Query("select i from Inproceedings i where"
            + " i.callId like concat('%', :word, '%') or"
            + " i.author like concat('%', :word, '%') or"
            + " i.title like concat('%', :word, '%') or"
            + " i.booktitle like concat('%', :word, '%') or"
            + " i.year like concat('%', :word, '%') or"
            + " i.editor like concat('%', :word, '%') or"
            + " i.volumeNumber like concat('%', :word, '%') or"
            + " i.series like concat('%', :word, '%') or"
            + " i.pages like concat('%', :word, '%') or"
            + " i.address like concat('%', :word, '%') or"
            + " i.month like concat('%', :word, '%') or"
            + " i.organization like concat('%', :word, '%') or"
            + " i.publisher like concat('%', :word, '%') or"
            + " i.note like concat('%', :word, '%')")
    public List<Inproceedings> findWord(@Param("word") String word);
    
    
}
