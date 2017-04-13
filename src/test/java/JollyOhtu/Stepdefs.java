package JollyOhtu;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
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

    /*
     Always use FirefoxDriver for pushing to github, otherwise Travis will fail 
     */
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
        WebElement element = driver.findElement(By.id("author"));
        element.sendKeys(author);
        element = driver.findElement(By.id("title"));
        element.sendKeys(title);
        element = driver.findElement(By.id("year"));
        element.sendKeys("" + year);
        element = driver.findElement(By.id("publisher"));
        element.sendKeys(publisher);

        element = driver.findElement(By.xpath("//button[contains(.,'Add')]"));
        element.submit();
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
