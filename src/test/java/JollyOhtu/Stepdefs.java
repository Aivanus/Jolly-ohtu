
package JollyOhtu;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class Stepdefs {
    @Given("^Test is initialised$")
    public void test_is_initialised() throws Throwable {
        Assert.assertTrue(true);
    }

    @When("^it is run$")
    public void it_is_run() throws Throwable {
        Assert.assertTrue(true);
    }

    @Then("^the value should be (\\d+)$")
    public void the_value_should_be(int arg1) throws Throwable {
        Assert.assertTrue(true);
    }

}
