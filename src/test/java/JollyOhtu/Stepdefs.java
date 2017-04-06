
package JollyOhtu;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.DEFINED_PORT)
@ContextConfiguration
public class Stepdefs {
    
    @Autowired
    private TestRestTemplate restTemplate;
    
    private ResponseEntity<String> response;
    
    @Given("^Add book view is selected$")
    public void add_book_view_is_selected() throws Throwable {
         response = restTemplate.exchange("/add_book", HttpMethod.GET, null, String.class);
         System.out.println(response.toString());
         
    }

    @When("^Valid book author \"([^\"]*)\", title \"([^\"]*)\", year (\\d+) and publisher \"([^\"]*)\" are given$")
    public void valid_book_author_title_year_and_publisher_are_given(String author, String title, int year, String publisher) throws Throwable {
        response = restTemplate.postForEntity("add_book", response, String.class);
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^new book reference is created$")
    public void new_book_reference_is_created() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }


}
