package page.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import page.methods.HeaderMenuMethods;
import page.methods.RegistrationPageMethod;

public class RegistrationSteps {

    private WebDriver driver;

    public RegistrationSteps() {
        driver = Hooks.driver;
    }

    @When("I navigate to the {string} page")
    public void i_navigate_to_the_page(String headerMenu) {
        HeaderMenuMethods.clickOnHeaderMenu(driver, headerMenu);
    }

    @And("I have entered valid registration details for {string}, {string}, {string}, {string}, {string}, {string}")
    public void i_have_entered_valid_registration_details_for(String gender, String firstName, String lastName, String email, String password, String companyName) {
        RegistrationPageMethod.fillRegistrationForm(driver, gender, firstName, lastName, email, password, companyName);
    }

    @And("I click the <string> button")
    public void i_click_the_button(String string) {
    }

    @Then("I should see the success message {string}")
    public void i_should_see_the_success_message(String string) {
    }
}
