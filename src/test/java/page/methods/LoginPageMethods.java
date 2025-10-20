package page.methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import page.objects.LoginPageObjects;
import page.steps.Hooks;

import java.time.Duration;

public class LoginPageMethods {

    private static final Logger logger = LoggerFactory.getLogger(LoginPageMethods.class);
    static WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(2000));

    public static void enterCorrectEmailInLoginPage(WebDriver driver, String email) {
        try {
            logger.info("Entering email '{}' in login page.", email);
            wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPageObjects.LOGIN_BUTTON));
            driver.findElement(LoginPageObjects.LOGIN_EMAIL).sendKeys(email);
            logger.info("Email entered successfully.");
        } catch (Exception e) {
            logger.error("Error while entering email '{}': {}", email, e.getMessage(), e);
        }
    }

    public static void enterCorrectPasswordInLoginPage(WebDriver driver, String password) {
        try {
            logger.info("Entering password in login page.");
            driver.findElement(LoginPageObjects.LOGIN_PASSWORD).sendKeys(password);
            logger.info("Password entered successfully.");
        } catch (Exception e) {
            logger.error("Error while entering password: {}", e.getMessage(), e);
        }
    }

    public static void clickOnLoginButton(WebDriver driver) {
        try {
            logger.info("Clicking on login button.");
            driver.findElement(LoginPageObjects.LOGIN_BUTTON).click();
            logger.info("Login button clicked successfully.");
        } catch (Exception e) {
            logger.error("Error while clicking login button: {}", e.getMessage(), e);
        }
    }
}