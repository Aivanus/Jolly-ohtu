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
public class FileObjectTest {

    FileObject f;

    public FileObjectTest() {
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
    public void createCorrectly() {
        FileObject fo = new FileObject();
        assertNotNull(fo);
    }

    @Test
    public void settingNameWorks() {
        f = new FileObject();
        f.setName("File");
        assertEquals("File.bib", f.getName());
    }
    
    @Test
    public void defaultNameIsSetCorrectly(){
        f = new FileObject();
        f.setName("");
        assertEquals("References.bib", f.getName());
    }
    
    @Test
    public void settingContentTypeWorks(){
        f = new FileObject();
        f.setContentType("text/plain");
        assertEquals("text/plain", f.getContentType());
    }
    
    @Test
    public void settingContentWorks(){
        f = new FileObject();
        f.setContent("Text to the file");
        assertEquals("Text to the file", f.getContent());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
