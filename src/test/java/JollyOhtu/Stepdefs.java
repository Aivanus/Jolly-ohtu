package JollyOhtu;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = Main.class)
//@SpringBootTest
public class Stepdefs {

    private WebDriver driver = new FirefoxDriver();
    String baseUrl = "https://sheltered-gorge-31986.herokuapp.com/";
    
    @Test
    public void inititalizeTest(){
        assertTrue(true);
        driver.quit();
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
        element.sendKeys(""+year);
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
