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
    private String callId;
    private String volume;
    private String series;
    private String address;
    private String edition;
    private String month;
    private String note;

    public Book(String callId, String author, String title, String publisher, int year, String volume, String series, String address, String edition, String month, String note) {
        this.callId = callId;
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
        return String.format("@book{ \"%s\", \n author = \"%s\",\n title = \"%s\",\n publisher = \"%s\",\n "
                + "year = \"%d\",\n volume = \"%s\",\n series = \"%s\",\n address = \"%s\",\n edition = \"%s\",\n "
                + "month = \"%s\",\n note = \"%s\"}\n",
                callId, author, title, publisher, year, volume, series, address, edition, month, note);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCallId() {
        return callId;
    }

    public void setCallId(String callId) {
        this.callId = callId;
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

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
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

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Boolean mandatoryFieldsAreFilled() {
        if (this.author.equalsIgnoreCase("") || this.title.equalsIgnoreCase("") || this.publisher.equalsIgnoreCase("")) {
            return false;
        } else {
            return true;
        }
    }

    public boolean bookHasInvalidInfo() {
        if (!this.month.isEmpty()) {
            if (Integer.parseInt(this.month) >= 1 && Integer.parseInt(this.month) <13) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    public Boolean initCallId() {
        if (callId.equals("")) {
            callId += authorIntoCallId();
            callId += yearIntoCallId();
            return true;
        } else {
            return false;
        }
    }

    private String authorIntoCallId() {
        if (this.author.isEmpty()) {
            return null;
        }
        String trueId = "";
        String trimmed = this.author.trim();
        trueId += trimmed.charAt(0);
        for (int i = 0; i < trimmed.length(); i++) {
            if (trimmed.charAt(i) == ' ') {
                trueId += trimmed.charAt(i + 1);
            }
        }
        return trueId;
    }

    private String yearIntoCallId() {
        String trueId = "";
        String yearInString = Integer.toString(this.year);
        if (yearInString.length() < 2) {
            trueId += yearInString;
        } else {
            trueId += yearInString.charAt(yearInString.length() - 2);
            trueId += yearInString.charAt(yearInString.length() - 1);
        }
        return trueId;
    }
}
