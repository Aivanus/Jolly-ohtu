package JollyOhtu;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.List;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = Main.class)
//@SpringBootTest
public class Stepdefs {

    private WebDriver driver = null;
    String baseUrl = "http://localhost:8080/";

    @Before
    public void setUp() {
        if (System.getProperty("os.name").startsWith("Windows")) {
            driver = new ChromeDriver();
        } else {
            driver = new FirefoxDriver();
        }
    }

    @Given("^Add book view is selected$")
    public void add_book_view_is_selected() throws Throwable {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("Add Book"));
        element.click();
    }

    @When("^Valid book author \"([^\"]*)\", title \"([^\"]*)\", year (\\d+) and publisher \"([^\"]*)\" are given$")
    public void valid_book_author_title_year_and_publisher_are_given(String author, String title, int year, String publisher) throws Throwable {
        driver.findElement(By.id("author")).sendKeys(author);
        driver.findElement(By.id("title")).sendKeys(title);
        driver.findElement(By.id("year")).sendKeys("" + year);
        driver.findElement(By.id("publisher")).sendKeys(publisher);

        driver.findElement(By.xpath("//button[contains(.,'Add')]")).submit();

    }

    @When("^Valid mandatory book information is entered:$")
    public void valid_mandatory_book_information_is_entered(List<List<String>> table) throws Throwable {      
        driver.findElement(By.id("author")).sendKeys(table.get(0).get(1));
        driver.findElement(By.id("title")).sendKeys(table.get(1).get(1));
        driver.findElement(By.id("year")).sendKeys(table.get(2).get(1));
        driver.findElement(By.id("publisher")).sendKeys(table.get(3).get(1));
        // Click submit
        driver.findElement(By.xpath("//button[contains(.,'Add')]")).submit();
    }

    @Then("^new book reference is created$")
    public void new_book_reference_is_created() throws Throwable {
        pageHasContent("Reference was saved succesfully!");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    // Helper methods
    private void pageHasContent(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }
}
