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
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String author;
    private String title;
    private String publisher;
    private int year;

    //Optional fields
    private int volume;
    private String series;
    private String address;
    private String edition;
    private int month;
    private String note;

    public Book(String author, String title, String publisher, Integer year) {
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        this.year = year;
    }

    @Override
    public String toString() {
        return String.format("Book: author='%s', title='%s', publisher='%s', year='%d'",
                author, title, publisher, year);
    }

}
