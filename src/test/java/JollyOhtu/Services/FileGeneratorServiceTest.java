package JollyOhtu.Services;

import JollyOhtu.Objects.Article;
import JollyOhtu.Objects.Book;
import JollyOhtu.Objects.FileObject;
import JollyOhtu.Objects.Inproceedings;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Arttu
 */
public class FileGeneratorServiceTest {

    Book b = new Book("M15", "Mäkelä", "Kirja", "Kustantamo Yö", 2015, "0", "Series", "Yökyöpelinkatu 1", "", "0", "");
    Article a = new Article("B98", "Bob", "Article", "Journal", 1998, 1, "0", "215-220", "0", "");
    Inproceedings ip = new Inproceedings("C55", "Clark", "Proceeding", "Booktitle", 1955, "Edison", "0", "", "200", "", "0", "", "", "");

    public FileGeneratorServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void fileIsGeneratedCorrectly() throws IOException {
        List<Book> books = new ArrayList<>();
        List<Article> articles = new ArrayList<>();
        List<Inproceedings> inpros = new ArrayList<>();
        books.add(b);
        articles.add(a);
        inpros.add(ip);
        String wanted = wantedFormat();
        FileGeneratorService fgs = new FileGeneratorService();
        FileObject generated = fgs.generateFile(books, articles, inpros);
        Assert.assertThat(generated.getContent(), CoreMatchers.equalTo(wanted));
    }

    private String wantedFormat() {
        return "@article{ B98, \n"
                + " author = \"Bob\",\n"
                + " title = \"Article\",\n"
                + " journal = \"Journal\",\n"
                + " year = \"1998\",\n"
                + " volume = \"1\",\n"
                + " number = \"0\",\n"
                + " pages = \"215-220\",\n"
                + " month = \"0\",\n"
                + " note = \"\"} \n"
                + "@book{ M15, \n"
                + " author = \"M{\\\"a}kel{\\\"a}\",\n"
                + " title = \"Kirja\",\n"
                + " publisher = \"Kustantamo Y{\\\"o}\",\n"
                + " year = \"2015\",\n"
                + " volume = \"0\",\n"
                + " series = \"Series\",\n"
                + " address = \"Y{\\\"o}ky{\\\"o}pelinkatu 1\",\n"
                + " edition = \"\",\n"
                + " month = \"0\",\n"
                + " note = \"\"}\n"
                + "@inproceedings{ C55, \n"
                + " author = \"Clark\",\n"
                + " title = \"Proceeding\",\n"
                + " booktitle = \"Booktitle\",\n"
                + " year = \"1955\",\n"
                + " editor = \"Edison\",\n"
                + " volumeNumber = \"0\",\n"
                + " series = \"\",\n"
                + " pages = \"200\",\n"
                + " address = \"\",\n"
                + " month = \"0\",\n"
                + " organization = \"\",\n"
                + " publisher = \"\",\n"
                + " note = \"\"} \n";
    }
}
