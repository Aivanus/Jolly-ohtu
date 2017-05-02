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
    private String callId;
    private String number;
    private String pages;
    private String month;
    private String note;

    public Article(String callId, String author, String title, String journal, int year, int volume, String number, String pages, String month, String note) {
        this.author = author;
        this.title = title;
        this.journal = journal;
        this.year = year;
        this.volume = volume;
        this.number = number;
        this.pages = pages;
        this.month = month;
        this.note = note;
        this.callId = callId;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String page) {
        this.pages = page;
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

    @Override
    public String toString() {
        return String.format("@article{ %s, \n author = \"%s\",\n title = \"%s\",\n journal = \"%s\",\n "
                + "year = \"%d\",\n volume = \"%s\",\n number = \"%s\",\n pages = \"%s\",\n month = \"%s\",\n note = \"%s\"} \n",
                callId, author, title, journal, year, volume, number, pages, month, note);
    }

    public Boolean mandatoryFieldsArentFilled() {
        if (this.author.equalsIgnoreCase("") || this.title.equalsIgnoreCase("") || this.journal.equalsIgnoreCase("")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean articleHasInvalidInfo() {
        if (!this.month.isEmpty()) {
            if (Integer.parseInt(this.month) >= 1 && Integer.parseInt(this.month) < 13) {
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
