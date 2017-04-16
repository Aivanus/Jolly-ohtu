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
    
    
}
