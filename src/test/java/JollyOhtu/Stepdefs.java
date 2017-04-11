package JollyOhtu;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Main.class)
@SpringBootTest
public class Stepdefs {


    private WebDriver driver = new ChromeDriver();
    String baseUrl = "https://sheltered-gorge-31986.herokuapp.com/";
    

    @Given("^Add book view is selected$")
    public void add_book_view_is_selected() throws Throwable {
        driver.get(baseUrl);
        Thread.sleep(10000);
        
        driver.quit();

    }

    @When("^Valid book author \"([^\"]*)\", title \"([^\"]*)\", year (\\d+) and publisher \"([^\"]*)\" are given$")
    public void valid_book_author_title_year_and_publisher_are_given(String author, String title, int year, String publisher) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^new book reference is created$")
    public void new_book_reference_is_created() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
