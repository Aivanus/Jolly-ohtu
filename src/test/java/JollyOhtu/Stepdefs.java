
package JollyOhtu;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Stepdefs {
    
//    WebDriver driver = new ChromeDriver();
    WebDriver driver = new HtmlUnitDriver();
//    String baseUrl = "http://localhost:8080";
    
    @Given("^Add book view is selected$")
    public void add_book_view_is_selected() throws Throwable {
//        driver.get(baseUrl);
//        System.out.println(driver.getPageSource());
//        WebElement element = driver.findElement(By.linkText("Add Book"));
//        element.click();
//        System.out.println(driver.getPageSource());
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
