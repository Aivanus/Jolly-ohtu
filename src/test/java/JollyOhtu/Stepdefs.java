package JollyOhtu;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

//@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = Main.class)
//@SpringBootTest
public class Stepdefs {

    private WebDriver driver = null;
    String baseUrl = "http://localhost:8080/";

    @Before
    public void setUp() {
        /*if (System.getProperty("os.name").startsWith("Windows")) {
            driver = new ChromeDriver();
        } else {
            driver = new FirefoxDriver();
        }*/
        driver = new HtmlUnitDriver();
    }

    @Given("^Add book view is selected$")
    public void add_book_view_is_selected() throws Throwable {
        driver.get(baseUrl);
        driver.findElement(By.linkText("Add Book")).click();
    }

    @Given("^Add article view is selected$")
    public void add_article_view_is_selected() throws Throwable {
        driver.get(baseUrl);
        driver.findElement(By.linkText("Add Article")).click();
    }

    @Given("^Add inproceedings view is selected$")
    public void add_inproceedings_view_is_selected() throws Throwable {
        driver.get(baseUrl);
        driver.findElement(By.linkText("Add Inproceedings")).click();
    }

    @Given("^Download file view has been selected$")
    public void download_file_view_has_been_selected() throws Throwable {
        driver.get(baseUrl);
        driver.findElement(By.linkText("Download file")).click();
    }

    @When("^Valid mandatory book information is entered:$")
    public void valid_mandatory_book_information_is_entered(List<List<String>> table) throws Throwable {
        enterValuesById(table);
    }

    @When("^No mandatory book information is entered:$")
    public void no_mandatory_book_information_is_entered(List<List<String>> table) throws Throwable {
        enterValuesById(table);
    }

    @When("^Optional fields are chosen$")
    public void optional_fields_are_chosen() throws Throwable {
        driver.findElement(By.xpath("//button[contains(.,'Additional fields')]")).click();
    }

    @When("^Valid optional field information is entered:$")
    public void valid_optional_field_information_is_entered(List<List<String>> table) throws Throwable {
        enterValuesById(table);
    }

    @When("^Invalid optional field information is entered:$")
    public void invalid_optional_field_information_is_entered(List<List<String>> table) throws Throwable {
        enterValuesById(table);
    }

    @When("^Mandatory book information with only author and title is entered:$")
    public void mandatory_book_information_with_only_author_and_title_is_entered(List<List<String>> table) throws Throwable {
        enterValuesById(table);
    }

    @When("^Valid mandatory article information is entered:$")
    public void valid_mandatory_article_information_is_entered(List<List<String>> table) throws Throwable {
        enterValuesById(table);
    }

    @When("^No mandatory article information is entered:$")
    public void no_mandatory_article_information_is_entered(List<List<String>> table) throws Throwable {
        enterValuesById(table);
    }

    @When("^User presses button Add$")
    public void user_presses_button_add() throws Throwable {
        driver.findElement(By.xpath("//button[contains(.,'Add')]")).submit();
    }

    @When("^Mandatory article information with only author and title is entered:$")
    public void mandatory_article_information_with_only_author_and_title_is_entered(List<List<String>> table) throws Throwable {
        enterValuesById(table);
    }

    @When("^Mandatory inproceedings information with only author and title is entered:$")
    public void mandatory_inproceedings_information_with_only_author_and_title_is_entered(List<List<String>> table) throws Throwable {
        enterValuesById(table);
    }

    @When("^Valid mandatory inproceedings information is entered:$")
    public void valid_mandatory_inproceedings_information_is_entered(List<List<String>> table) throws Throwable {
        enterValuesById(table);
    }

    @When("^No mandatory inproceedings information is entered:$")
    public void no_mandatory_inproceedings_information_is_entered(List<List<String>> table) throws Throwable {
        enterValuesById(table);
    }

    @When("^File name \"([^\"]*)\" is entered$")
    public void file_name_is_entered(String name) throws Throwable {
        driver.findElement(By.name("name")).sendKeys(name);

    }

    @When("^I press Generate file button")
    public void user_presses_button_generate_file() throws Throwable {
        driver.findElement(By.xpath("//button[contains(.,'Generate file')]")).submit();
    }

    @Then("^Message \"([^\"]*)\" is presented$")
    public void message_is_presented(String message) throws Throwable {
        pageHasContent(message);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    // Helper methods
    private void pageHasContent(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }

    private void enterValuesById(List<List<String>> table) {
        for (List<String> table1 : table) {
            driver.findElement(By.id(table1.get(0))).sendKeys(table1.get(1));
        }
    }

    // Use for debugging to pause selenium 
    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ex) {
            Logger.getLogger(Stepdefs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
