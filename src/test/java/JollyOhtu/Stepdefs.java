package JollyOhtu;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.assertFalse;
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

        if (System.getProperty("os.name").startsWith("Windows")) {
            driver = new HtmlUnitDriver();
//                        driver = new ChromeDriver();
        } else {
            driver = new FirefoxDriver();
        }

    }

    /*
    
    
    
    Given steps
    
    
    
     */
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

    @Given("^List view is selected$")
    public void list_view_is_selected() throws Throwable {
        driver.get(baseUrl);
        driver.findElement(By.linkText("List References")).click();
    }

    @Given("^Book reference is successfully created with following fields:$")
    public void book_reference_is_successfully_created_with_following_fields(List<List<String>> table) throws Throwable {
        add_book_view_is_selected();
        optional_fields_are_chosen();
        enterValuesById(table);
        user_presses_button_add();
        message_is_presented("Reference was saved successfully!");
    }

    @Given("^Book reference with author \"([^\"]*)\" is not created$")
    public void book_reference_with_author_is_not_created(String author) throws Throwable {
        add_book_view_is_selected();
        driver.findElement(By.id("author")).sendKeys(author);
        user_presses_button_add();
        message_is_presented("You must fill in the fields marked by *");
    }

    @Given("^Article reference is successfully created with following fields:$")
    public void article_reference_is_successfully_created_with_following_fields(List<List<String>> table) throws Throwable {
        add_article_view_is_selected();
        optional_fields_are_chosen();
        enterValuesById(table);
        user_presses_button_add();
        message_is_presented("Reference was saved successfully!");
    }

    @Given("^Article reference with author \"([^\"]*)\" is not created$")
    public void article_reference_with_author_is_not_created(String author) throws Throwable {
        add_book_view_is_selected();
        driver.findElement(By.id("author")).sendKeys(author);
        user_presses_button_add();
        message_is_presented("You must fill in the fields marked by *");
    }

    @Given("^Inproceedings reference is successfully created with following fields:$")
    public void inproceedings_reference_is_successfully_created_with_following_fields(List<List<String>> table) throws Throwable {
        add_inproceedings_view_is_selected();
        optional_fields_are_chosen();
        enterValuesById(table);
        user_presses_button_add();
        message_is_presented("Reference was saved successfully!");
    }

    @Given("^Inproceedings reference with author \"([^\"]*)\" is not created$")
    public void inproceedings_reference_with_author_is_not_created(String author) throws Throwable {
        add_inproceedings_view_is_selected();
        driver.findElement(By.id("author")).sendKeys(author);
        user_presses_button_add();
        message_is_presented("You must fill in the fields marked by *");
    }

    @Given("^Download file view has been selected$")
    public void download_file_view_has_been_selected() throws Throwable {
        driver.get(baseUrl);
        driver.findElement(By.linkText("Download file")).click();
    }

    /*
    
    
    
    When steps
    
    
    
    
     */
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

    @When("File name is entered:$")
    public void file_name_is_entered(List<List<String>> table) throws Throwable {
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

    @When("^Checkbox next to the book is selected$")
    public void checkbox_next_to_the_book_is_selected() throws Throwable {
        driver.findElement(By.xpath("//form[1]/div/table/tbody/tr[2]/td[12]/input[@type='checkbox']")).click();
    }

    @When("^Checkbox next to the article is selected$")
    public void checkbox_next_to_the_article_is_selected() throws Throwable {
        driver.findElement(By.xpath("//form[2]/div/table/tbody/tr[2]/td[12]/input[@type='checkbox']")).click();
    }

    @When("^Checkbox next to the inproceedings is selected$")
    public void checkbox_next_to_the_inproceedings_is_selected() throws Throwable {
        driver.findElement(By.xpath("//form[3]/div/table/tbody/tr[2]/td[16]/input[@type='checkbox']")).click();
    }

    @When("^User presses button Delete Selected for books$")
    public void user_presses_button_Delete_Selected_for_books() throws Throwable {
        driver.findElement(By.xpath("//form[1]/div/table/tbody/tr[1]/th[13]/button")).click();
    }

    @When("^User presses button Delete Selected for articles$")
    public void user_presses_button_Delete_Selected_for_articles() throws Throwable {
        driver.findElement(By.xpath("//form[2]/div/table/tbody/tr[1]/th[13]/button")).click();
    }

    @When("^User presses button Delete Selected for inrpoceedings$")
    public void user_presses_button_Delete_Selected_for_inproceedings() throws Throwable {
        driver.findElement(By.xpath("//form[3]/div/table/tbody/tr/th[17]/button")).click();
        sleep(2000);
    }

    @When("^User presses button Select All for books$")
    public void user_presses_button_Select_All_for_books() throws Throwable {
        driver.findElement(By.xpath("//form[1]/div/table/tbody/tr/th[12]/button")).click();
    }

    @When("^User presses button Select All for articles$")
    public void user_presses_button_Select_All_for_articles() throws Throwable {
        driver.findElement(By.xpath("//form[2]/div/table/tbody/tr[1]/th[12]/button")).click();

    }

    @When("^User presses button Select All for inproceedings$")
    public void user_presses_button_Select_All_for_inproceedings() throws Throwable {
        driver.findElement(By.xpath("//form[3]/div/table/tbody/tr/th[16]/button")).click();

    }

    /*
    
    
    
    Then steps
    
    
    
     */
    @Then("^Message \"([^\"]*)\" is presented$")
    public void message_is_presented(String message) throws Throwable {
        pageHasContent(message);
    }

    @Then("^List view is shown$")
    public void list_view_is_shown() throws Throwable {
        pageHasContent("Books");
        pageHasContent("Articles");
        pageHasContent("Inproceedings");
    }

    @Then("^Book reference row should be visible with following fields:$")
    public void book_reference_row_should_be_visible_with_following_fields(List<String> list) throws Throwable {
        for (String string : list) {
            pageHasContent(string);
        }
    }

    @Then("^Article reference row should be visible with following fields:$")
    public void article_reference_row_should_be_visible_with_following_fields(List<String> list) throws Throwable {
        for (String string : list) {
            pageHasContent(string);
        }
    }

    @Then("^Inproceedings reference row should be visible with following fields:$")
    public void inproceedings_reference_row_should_be_visible_with_following_fields(List<String> list) throws Throwable {
        for (String string : list) {
            pageHasContent(string);
        }
    }

    @Then("^Row with author \"([^\"]*)\" should not be visible$")
    public void row_with_author_should_not_be_visible(String author) throws Throwable {
        pageDoesntHaveContent(author);
    }

    @Then("^User is on download page$")
    public void user_is_on_download_page() throws Throwable {
        pageHasContent("File name");
    }


    /*
    
    
    
    Other methods
    
    
    
     */
    @After
    public void tearDown() {
        driver.quit();
    }

    // Helper methods
    private void pageHasContent(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }

    private void pageDoesntHaveContent(String content) {
        assertFalse(driver.getPageSource().contains(content));
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
