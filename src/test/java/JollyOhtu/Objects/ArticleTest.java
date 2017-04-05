package JollyOhtu.Objects;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by topi on 5.4.2017.
 */
public class ArticleTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void articleIsCreatedProperly() throws Exception {
        Article article = new Article("Author", "Title", "Journal", 1995, 1);
        assertEquals("Article{author=Author, title=Title, journal=Journal, year=1995, volume=1, number=0, pages=null, month=0, note=null}", article.toString());

    }

    @Test
    public void articleCreatedProperlyLongConstructor() throws Exception {
        Article article = new Article("Author", "Title", "Journal", 1995, 1, 0, "10-15", 9, "Note");
        assertEquals("Article{author=Author, title=Title, journal=Journal, year=1995, volume=1, number=0, pages=10-15, month=9, note=Note}", article.toString());
    }

}