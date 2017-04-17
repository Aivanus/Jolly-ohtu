package JollyOhtu.Objects;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 * Created by topi on 5.4.2017.
 */
public class InproceedingsTest {

    private Inproceedings inpro;

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {

        inpro = new Inproceedings("author", "title", "booktitle", 1995, "editor", 5, "series", "3-4", "address", 5, "organization", "publisher", "note");

    }

    @After
    public void tearDown() throws Exception {

    }

//    @Test
//    public void emptyConstructor() throws Exception {
//        Inproceedings inproceedings = new Inproceedings();
//        assertEquals("Inproceedings: title=null year=0", proceeding.toString());
//    }
    @Test
    public void inproceedingsIsCreatedCorrectly() throws Exception {
        Inproceedings inproceedings = new Inproceedings("Author", "Title",
                "Booktitle", 1995, "Editor", 5, "Series", "5-25", "Address", 4,
                "Organization", "Publisher", "Note");
        assertEquals("@inproceedings{ tunnus, \n author = \"Author\",\n title = \"Title\",\n booktitle = \"Booktitle\",\n year = \"1995\",\n "
                + "editor = \"Editor\",\n volumeNumber = \"5\",\n series = \"Series\",\n pages = \"5-25\",\n address = \"Address\",\n "
                + "month = \"4\",\n organization = \"Organization\",\n publisher = \"Publisher\",\n note = \"Note\"} \n", inproceedings.toString());
        ;
    }

//    /**
//     * Test of getId method, of class Inproceedings.
//     */
//    @Test
//    public void testGetId() {
//        System.out.println("getId");
//        Inproceedings instance = new Inproceedings();
//        Long expResult = null;
//        Long result = instance.getId();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    /**
//     * Test of setId method, of class Inproceedings.
//     */
//    @Test
//    public void testSetId() {
//        System.out.println("setId");
//        Long id = null;
//        Inproceedings instance = new Inproceedings();
//        instance.setId(id);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of getAuthor method, of class Inproceedings.
     */
    @Test
    public void testGetAuthor() {
        String expResult = "author";
        String result = inpro.getAuthor();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAuthor method, of class Inproceedings.
     */
    @Test
    public void testSetAuthor() {
        String author = "author2";
        inpro.setAuthor(author);
        assertEquals("author2", inpro.getAuthor());
    }

    /**
     * Test of getTitle method, of class Inproceedings.
     */
    @Test
    public void testGetTitle() {
        String expResult = "title";
        String result = inpro.getTitle();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTitle method, of class Inproceedings.
     */
    @Test
    public void testSetTitle() {
        String title = "title2";
        inpro.setTitle(title);
        assertEquals("title2", inpro.getTitle());
    }

    /**
     * Test of getBooktitle method, of class Inproceedings.
     */
    @Test
    public void testGetBooktitle() {
        String expResult = "booktitle";
        String result = inpro.getBooktitle();
        assertEquals(expResult, result);
    }

    /**
     * Test of setBooktitle method, of class Inproceedings.
     */
    @Test
    public void testSetBooktitle() {
        String booktitle = "title2";
        inpro.setBooktitle(booktitle);
        assertEquals("title2", inpro.getBooktitle());
    }

    /**
     * Test of getYear method, of class Inproceedings.
     */
    @Test
    public void testGetYear() {
        int expResult = 1995;
        int result = inpro.getYear();
        assertEquals(expResult, result);
    }

    /**
     * Test of setYear method, of class Inproceedings.
     */
    @Test
    public void testSetYear() {
        int year = 2000;
        inpro.setYear(year);
        assertEquals(2000, inpro.getYear());
    }

    /**
     * Test of getEditor method, of class Inproceedings.
     */
    @Test
    public void testGetEditor() {
        String expResult = "editor";
        String result = inpro.getEditor();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEditor method, of class Inproceedings.
     */
    @Test
    public void testSetEditor() {
        String editor = "editor2";
        inpro.setEditor(editor);
        assertEquals("editor2", inpro.getEditor());
    }

    /**
     * Test of getVolumeNumber method, of class Inproceedings.
     */
    @Test
    public void testGetVolumeNumber() {
        int expResult = 5;
        int result = inpro.getVolumeNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of setVolumeNumber method, of class Inproceedings.
     */
    @Test
    public void testSetVolumeNumber() {
        int volumeNumber = 10;
        inpro.setVolumeNumber(volumeNumber);
        assertEquals(10, inpro.getVolumeNumber());
    }

    /**
     * Test of getSeries method, of class Inproceedings.
     */
    @Test
    public void testGetSeries() {
        String expResult = "series";
        String result = inpro.getSeries();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSeries method, of class Inproceedings.
     */
    @Test
    public void testSetSeries() {
        String series = "series2";
        inpro.setSeries(series);
        assertEquals("series2", inpro.getSeries());
    }

    /**
     * Test of getPages method, of class Inproceedings.
     */
    @Test
    public void testGetPages() {
        String expResult = "3-4";
        String result = inpro.getPages();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPages method, of class Inproceedings.
     */
    @Test
    public void testSetPages() {
        String pages = "4-5";
        inpro.setPages(pages);
        assertEquals("4-5", inpro.getPages());
    }

    /**
     * Test of getAddress method, of class Inproceedings.
     */
    @Test
    public void testGetAddress() {
        String expResult = "address";
        String result = inpro.getAddress();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAddress method, of class Inproceedings.
     */
    @Test
    public void testSetAddress() {
        String address = "address2";
        inpro.setAddress(address);
        assertEquals("address2", inpro.getAddress());
    }

    /**
     * Test of getMonth method, of class Inproceedings.
     */
    @Test
    public void testGetMonth() {
        int expResult = 5;
        int result = inpro.getMonth();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMonth method, of class Inproceedings.
     */
    @Test
    public void testSetMonth() {
        int month = 4;
        inpro.setMonth(month);
        assertEquals(4, inpro.getMonth());
    }

    /**
     * Test of getOrganization method, of class Inproceedings.
     */
    @Test
    public void testGetOrganization() {
        String expResult = "organization";
        String result = inpro.getOrganization();
        assertEquals(expResult, result);
    }

    /**
     * Test of setOrganization method, of class Inproceedings.
     */
    @Test
    public void testSetOrganization() {
        String organization = "organization2";
        inpro.setOrganization(organization);
        assertEquals("organization2", inpro.getOrganization());
    }

    /**
     * Test of getPublisher method, of class Inproceedings.
     */
    @Test
    public void testGetPublisher() {
        String expResult = "publisher";
        String result = inpro.getPublisher();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPublisher method, of class Inproceedings.
     */
    @Test
    public void testSetPublisher() {
        String publisher = "publisher2";
        inpro.setPublisher(publisher);
        assertEquals("publisher2", inpro.getPublisher());
    }

    /**
     * Test of getNote method, of class Inproceedings.
     */
    @Test
    public void testGetNote() {
        String expResult = "note";
        String result = inpro.getNote();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNote method, of class Inproceedings.
     */
    @Test
    public void testSetNote() {
        String note = "note2";
        inpro.setNote(note);
        assertEquals("note2", inpro.getNote());
    }

}
