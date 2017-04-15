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
    
    public List<Inproceedings> findByAuthorAndTitleAndBooktitleAndYearAndEditorAndVolumeNumberAndSeriesAndPagesAndAddressAndMonthAndOrganizationAndPublisherAndNote(
            String author, String title, String booktitle, int year,
            String editor, int volumenumber, String series, String pages,
            String address, int month, String organization, String publisher,
            String note);
}
