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

    }

    @Test
    public void setVolume() throws Exception {

    }

    @Test
    public void getSeries() throws Exception {

    }

    @Test
    public void setSeries() throws Exception {

    }

    @Test
    public void getAddress() throws Exception {

    }

    @Test
    public void setAddress() throws Exception {

    }

    @Test
    public void getEdition() throws Exception {

    }

    @Test
    public void setEdition() throws Exception {

    }

    @Test
    public void getMonth() throws Exception {

    }

    @Test
    public void setMonth() throws Exception {

    }

    @Test
    public void getNote() throws Exception {

    }

    @Test
    public void setNote() throws Exception {

    }

    public BookTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        b = new Book("author", "title", "publisher", 1995);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void bookIsCreatedCorrectly() {
        Book book = new Book("Lee Child", "Killing Floor", "Bantam (UK)", 1997);
        assertEquals("Book: author='Lee Child', title='Killing Floor', publisher='Bantam (UK)', year='1997'", book.toString());
    }
}
