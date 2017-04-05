
package JollyOhtu;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class Stepdefs {
    
    
    @Given("^Add book view is selected$")
    public void add_book_view_is_selected() throws Throwable {

    }

    @When("^Valid book author \"([^\"]*)\", title \"([^\"]*)\", year (\\d+) and publisher \"([^\"]*)\" are given$")
    public void valid_book_author_title_year_and_publisher_are_given(String arg1, String arg2, int arg3, String arg4) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^new book reference is created$")
    public void new_book_reference_is_created() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }


}
