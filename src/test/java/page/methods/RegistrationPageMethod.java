package page.methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import page.objects.RegistrationPageObjects;
import page.steps.Hooks;

import java.time.Duration;

public class RegistrationPageMethod {

    private static final Logger logger = LoggerFactory.getLogger(RegistrationPageMethod.class);
    public static WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(2000));

    public static void fillRegistrationForm(WebDriver driver, String gender, String firstName, String lastName,
                                            String email, String password, String companyName) {
        try {
            logger.info("Filling registration form for user: {} {}", firstName, lastName);

            wait.until(ExpectedConditions.visibilityOfElementLocated(RegistrationPageObjects.GENDER_FEMALE_RADIO_BUTTON));

            // Select gender
            if (gender != null && gender.equalsIgnoreCase("male")) {
                driver.findElement(RegistrationPageObjects.GENDER_MALE_RADIO_BUTTON).click();
                logger.info("Selected gender: Male");
            } else {
                driver.findElement(RegistrationPageObjects.GENDER_FEMALE_RADIO_BUTTON).click();
                logger.info("Selected gender: Female");
            }

            // Fill other form fields
            driver.findElement(RegistrationPageObjects.FIRST_NAME_INPUT).sendKeys(firstName);
            driver.findElement(RegistrationPageObjects.LAST_NAME_INPUT).sendKeys(lastName);
            driver.findElement(RegistrationPageObjects.EMAIL_INPUT).sendKeys(email);
            driver.findElement(RegistrationPageObjects.PASSWORD_INPUT).sendKeys(password);
            driver.findElement(RegistrationPageObjects.CONFIRM_PASSWORD_INPUT).sendKeys(password);
            driver.findElement(RegistrationPageObjects.COMPANY_NAME).sendKeys(companyName);

            // Click register button
            driver.findElement(RegistrationPageObjects.REGISTER_BUTTON).click();
            logger.info("Clicked on Register button.");

            logger.info("Registration form submitted successfully for email: {}", email);

        } catch (Exception e) {
            logger.error("Error while filling registration form for email '{}': {}", email, e.getMessage(), e);
        }
    }
}