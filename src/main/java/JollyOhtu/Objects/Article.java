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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String page) {
        this.pages = page;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return String.format("@article{ tunnus, \n author = \"%s\",\n title = \"%s\",\n journal = \"%s\",\n "
                + "year = \"%d\",\n volume = \"%d\",\n number = \"%d\",\n pages = \"%s\", month = \"%d\",\n note = \"%s\"} \n",
                author, title, journal, year, volume, number, pages, month, note);
    }

    public Boolean mandatoryFieldsAreFilled() {
        if (this.author.equalsIgnoreCase("") || this.title.equalsIgnoreCase("") || this.journal.equalsIgnoreCase("")) {
            return false;
        } else {
            return true;
        }
    }
}
