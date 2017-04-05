package JollyOhtu.Objects;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by topi on 5.4.2017.
 */
public class ProceedingTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void proceedingIsCreatedCorrectly() throws Exception {
        Proceeding proceeding = new Proceeding("Title", 1995);
        assertEquals("Proceeding: title=Title year=1995", proceeding.toString());
    }

}