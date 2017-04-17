/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JollyOhtu.Objects;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author Arttu
 */
public class BookTest {
    private Book b;
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        b = new Book("author", "title", "publisher", 1995, 1, "series", "address", "edition", 1, "note");
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void getId() throws Exception {

    }

    @Test
    public void setId() throws Exception {

    }

    @Test
    public void getAuthor() throws Exception {
        assertEquals("author", b.getAuthor());

    }

    @Test
    public void setAuthor() throws Exception {
        b.setAuthor("author1");
        assertEquals("author1", b.getAuthor());

    }

    @Test
    public void getTitle() throws Exception {
        assertEquals("title", b.getTitle());

    }

    @Test
    public void setTitle() throws Exception {
    b.setTitle("title1");
        assertEquals("title1", b.getTitle());
    }

    @Test
    public void getPublisher() throws Exception {
        assertEquals("publisher", b.getPublisher());

    }

    @Test
    public void setPublisher() throws Exception {
        b.setPublisher("publisher1");
        assertEquals("publisher1", b.getPublisher());

    }

    @Test
    public void getYear() throws Exception {
        assertEquals(1995, b.getYear());

    }

    @Test
    public void setYear() throws Exception {
        b.setYear(1996);
        assertEquals(1996, b.getYear());

    }

    @Test
    public void getVolume() throws Exception {
        assertEquals(1, b.getVolume());
    }

    @Test
    public void setVolume() throws Exception {
        b.setVolume(2);
        assertEquals(2, b.getVolume());
    }

    @Test
    public void getSeries() throws Exception {
        assertEquals("series", b.getSeries());
    }

    @Test
    public void setSeries() throws Exception {
        b.setSeries("series1");
        assertEquals("series1", b.getSeries());
    }

    @Test
    public void getAddress() throws Exception {
        assertEquals("address", b.getAddress());
    }

    @Test
    public void setAddress() throws Exception {
        b.setAddress("address1");
        assertEquals("address1", b.getAddress());
    }

    @Test
    public void getEdition() throws Exception {
        assertEquals("edition", b.getEdition());
    }

    @Test
    public void setEdition() throws Exception {
        b.setEdition("edition1");
        assertEquals("edition1", b.getEdition());
    }

    @Test
    public void getMonth() throws Exception {
        assertEquals(1, b.getMonth());
    }

    @Test
    public void setMonth() throws Exception {
        b.setMonth(2);
        assertEquals(2, b.getMonth());
    }

    @Test
    public void getNote() throws Exception {
        assertEquals("note", b.getNote());
    }

    @Test
    public void setNote() throws Exception {
        b.setNote("note1");
        assertEquals("note1", b.getNote());
    }

    public BookTest() {
    }
    
    
    
    @Test
    public void bookIsCreatedCorrectly() {
        Book book = new Book("Lee Child", "Killing Floor", "Bantam (UK)", 1997, 4, "Jack Reacher", "", "", 3, "");
        assertEquals("@book{ tunnus, \n author = \"Lee Child\",\n title = \"Killing Floor\",\n publisher = \"Bantam (UK)\",\n"
                + " year = \"1997\",\n volume = \"4\",\n series = \"Jack Reacher\",\n address = \"\",\n edition = \"\",\n"
                + " month = \"3\",\n note = \"\"}\n", book.toString());
    }
}
