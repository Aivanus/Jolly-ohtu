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
public class Inproceedings {

    public Inproceedings() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String callId;
    private String author;
    private String title;
    private String booktitle;
    private int year;

    //Optional fields
    private String editor;
    private int volumeNumber;
    private String series;
    private String pages;
    private String address;
    private int month;
    private String organization;
    private String publisher;
    private String note;

    public Inproceedings(String callId, String author, String title, String booktitle, int year, String editor, int volumeNumber, String series, String pages, String address, int month, String organization, String publisher, String note) {
        this.callId = "inpro"+callId;
        this.author = author;
        this.title = title;
        this.booktitle = booktitle;
        this.year = year;
        this.editor = editor;
        this.volumeNumber = volumeNumber;
        this.series = series;
        this.pages = pages;
        this.address = address;
        this.month = month;
        this.organization = organization;
        this.publisher = publisher;
        this.note = note;
    }

    @Override
    public String toString() {
        return "@inproceedings{ \""+ this.callId + "\", \n " + "author = \"" + author + "\",\n title = \"" + title + 
                "\",\n booktitle = \"" + booktitle + "\",\n year = \"" + year + "\",\n editor = \"" + 
                editor + "\",\n volumeNumber = \"" + volumeNumber + "\",\n series = \"" + 
                series + "\",\n pages = \"" + pages + "\",\n address = \"" + address + 
                "\",\n month = \"" + month + "\",\n organization = \"" + organization + 
                "\",\n publisher = \"" + publisher + "\",\n note = \"" + note + "\"} \n";
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

    public String getBooktitle() {
        return booktitle;
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public int getVolumeNumber() {
        return volumeNumber;
    }

    public void setVolumeNumber(int volumeNumber) {
        this.volumeNumber = volumeNumber;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Boolean mandatoryFieldsArentFilled(){
        if (this.author.equalsIgnoreCase("") || this.title.equalsIgnoreCase("") || this.booktitle.equalsIgnoreCase("")){
            return true;
        } else {
            return false;
        }
    }    
    
    public boolean inproceedingsHasInvalidInfo() {
        if (this.month >= 0 && this.month < 13) {
            return false;
        } else {
            return true;
        }
    }
    
}
