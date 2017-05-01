package JollyOhtu.Objects;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by topi on 5.4.2017.
 */
public class ArticleTest {

    private Article a;
    private Article aMand;

    @Test
    public void getId() throws Exception {
    }

    @Test
    public void setId() throws Exception {
        a.setId(((long) 5));
        assertEquals((long) 5, a.getId(), 0.1);
    }
    
    @Test
    public void getCallId(){
        assertEquals("callId", a.getCallId());
    }
    
    @Test
    public void setCallId(){
        a.setCallId("callId2");
        assertEquals("callId2", a.getCallId());
    }
    
    @Test
    public void getAuthor() throws Exception {
        assertEquals("author", a.getAuthor());

    }

    @Test
    public void setAuthor() throws Exception {
        a.setAuthor("author1");
        assertEquals("author1", a.getAuthor());

    }

    @Test
    public void getTitle() throws Exception {
        assertEquals("title", a.getTitle());

    }

    @Test
    public void setTitle() throws Exception {
        a.setTitle("title1");
        assertEquals("title1", a.getTitle());

    }

    @Test
    public void getJournal() throws Exception {
        assertEquals("journal", a.getJournal());

    }

    @Test
    public void setJournal() throws Exception {
        a.setJournal("journal1");
        assertEquals("journal1", a.getJournal());

    }

    @Test
    public void getYear() throws Exception {
        assertEquals(1995, a.getYear());

    }

    @Test
    public void setYear() throws Exception {
        a.setYear(1996);
        assertEquals(1996, a.getYear());

    }

    @Test
    public void getVolume() throws Exception {
        assertEquals(1, a.getVolume());

    }

    @Test
    public void setVolume() throws Exception {
        a.setVolume(2);
        assertEquals(2, a.getVolume());

    }

    @Test
    public void getNumber() throws Exception {
        assertEquals("1", a.getNumber());

    }

    @Test
    public void setNumber() throws Exception {
        a.setNumber("2");
        assertEquals("2", a.getNumber());

    }

    @Test
    public void getPages() throws Exception {
        assertEquals("1-5", a.getPages());

    }

    @Test
    public void setPages() throws Exception {
        a.setPages("1-6");
        assertEquals("1-6", a.getPages());

    }

    @Test
    public void getMonth() throws Exception {
        assertEquals("1", a.getMonth());

    }

    @Test
    public void setMonth() throws Exception {
        a.setMonth("2");
        assertEquals("2", a.getMonth());
    }

    @Test
    public void getNote() throws Exception {
        assertEquals("note", a.getNote());

    }

    @Test
    public void setNote() throws Exception {
        a.setNote("note1");
        assertEquals("note1", a.getNote());
    }

    @Before
    public void setUp() throws Exception {
        a = new Article("callId", "author", "title", "journal", 1995, 1, "1", "1-5", "1", "note");
        aMand = new Article("", "author", "title", "journal", 1995, 1, "", "", "", "");
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void emptyConstructor() throws Exception {
        Article article = new Article();
        assertEquals("@article{ \"null\", \n author = \"null\",\n title = \"null\",\n journal = \"null\",\n year = \"0\",\n "
                + "volume = \"0\",\n number = \"null\",\n pages = \"null\",\n month = \"null\",\n note = \"null\"} \n", article.toString());
    }

    
    @Test
    public void articleCreatedProperlyLongConstructor() throws Exception {
        Article article = new Article("callId", "Author", "Title", "Journal", 1995, 1, "0", "10-15", "9", "Note");
        assertEquals("@article{ \"callId\", \n author = \"Author\",\n title = \"Title\",\n journal = \"Journal\",\n year = \"1995\",\n "
                + "volume = \"1\",\n number = \"0\",\n pages = \"10-15\",\n month = \"9\",\n note = \"Note\"} \n", article.toString());
    }
    
    @Test
    public void articleHasInvalidorValidInfo(){
        Article arti = new Article("callId", "author", "title", "journal", 1995, 1, "1", "1-5", "13", "note");
        assertTrue(arti.articleHasInvalidInfo());
        arti.setMonth("5");
        assertFalse(arti.articleHasInvalidInfo());
    }
    
    @Test
    public void InitCallIdWorks(){
        assertTrue(aMand.initCallId());
        assertFalse(a.initCallId());
    }
    
    @Test
    public void authorIntoCallIDWorks(){
        Article arti = new Article("", "", "title", "journal", 1995, 1, "1", "1-5", "13", "note");
        assertTrue(arti.initCallId());
    }
    
    @Test
    public void yearIntoCallIdWorks(){
        Article arti = new Article("", "author", "title", "journal", 3, 1, "1", "1-5", "13", "note");
        assertTrue(arti.initCallId());
    }
}
