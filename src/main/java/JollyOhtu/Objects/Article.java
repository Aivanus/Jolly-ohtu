package JollyOhtu.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;

/**
 *
 * @author ritakosk
 */
@Entity
public class Article {

    public Article() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String author;
    private String title;
    private String journal;
    private int year;
    private int volume;

    //optional
    private int number;
    private String pages;
    private int month;
    private String note;

    public Article(String author, String title, String journal, int year, int volume) {
        this.author = author;
        this.title = title;
        this.journal = journal;
        this.year = year;
        this.volume = volume;
    }

    public Article(String author, String title, String journal, int year, int volume, int number, String pages, int month, String note) {
        this.author = author;
        this.title = title;
        this.journal = journal;
        this.year = year;
        this.volume = volume;
        this.number = number;
        this.pages = pages;
        this.month = month;
        this.note = note;
    }

    @Override
    public String toString() {
        return "Article{" + "author=" + author + ", title=" + title + ", journal=" + journal + ", year=" + year + ", volume=" + volume + ", number=" + number + ", pages=" + pages + ", month=" + month + ", note=" + note + '}';
    }

}
