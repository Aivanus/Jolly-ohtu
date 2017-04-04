package JollyOhtu.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Arttu
 */
@Entity
public class Proceeding {

    public Proceeding() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private int year;

    //Optional fields
    private String editor;
    private int volume;
    private String series;
    private String address;
    private int month;
    private String publisher;
    private String organization;
    private String note;

    public Proceeding(String title, int year) {
        this.title = title;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Proceeding: title=" + title + " year=" + year;
    }
}
