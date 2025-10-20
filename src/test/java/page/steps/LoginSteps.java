package page.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import page.methods.LoginPageMethods;

public class LoginSteps {
    private WebDriver driver;

    public LoginSteps() {
        this.driver = Hooks.driver;
    }

    @When("I enter a valid email {string} into the email field")
    public void i_enter_a_valid_email_into_the_email_field(String email) {
        LoginPageMethods.enterCorrectEmailInLoginPage(driver, email);
    }
    @And("I enter a valid password {string} into the password field")
    public void i_enter_a_valid_password_into_the_password_field(String password) {
        LoginPageMethods.enterCorrectPasswordInLoginPage(driver,password);
    }
    @And("I click the on login button")
    public void i_click_the_on_login_button() {
        LoginPageMethods.clickOnLoginButton(driver);
    }
}
