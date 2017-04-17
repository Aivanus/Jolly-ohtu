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

    public Book() {
    }

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

    public Book(String author, String title, String publisher, int year, int volume, String series, String address, String edition, int month, String note) {
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        this.year = year;
        this.volume = volume;
        this.series = series;
        this.address = address;
        this.edition = edition;
        this.month = month;
        this.note = note;
    }
    
    

    @Override
    public String toString() {
        return String.format("Book: author='%s', title='%s', publisher='%s', "
                + "year='%d', volume='%d', series='%s', address='%s', edition='%s', "
                + "month='%d', note='%s'",
                author, title, publisher, year, volume, series, address, edition, month, note);
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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
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

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
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
    
    public Boolean mandatoryFieldsAreFilled(){
        if (this.author.equalsIgnoreCase("") || this.title.equalsIgnoreCase("") || this.publisher.equalsIgnoreCase("")){
            return false;
        } else {
            return true;
        }
    }
    
    public boolean bookHasInvalidInfo(){
        if (this.month >= 0 && this.month < 13) {
            return false;
        } else {
            return true;
        }
    }

}
