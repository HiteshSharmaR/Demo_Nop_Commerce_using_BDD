package page.methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import page.steps.Hooks;

import java.time.Duration;
import java.util.List;

public class ComputersPageMethods {

    private static final Logger logger = LoggerFactory.getLogger(ComputersPageMethods.class);
    static WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(2000));

    public static void clickOnProductName(WebDriver driver, String productName) {
        try {
            logger.info("Attempting to click on product: {}", productName);

            wait.until(ExpectedConditions.visibilityOfElementLocated(page.objects.ComputerPageObjects.CLICK_ON_PRODUCT_NAME));

            List<WebElement> productNames = driver.findElements(page.objects.ComputerPageObjects.CLICK_ON_PRODUCT_NAME);
            boolean productFound = false;

            for (WebElement name : productNames) {
                if (name.getText().trim().equalsIgnoreCase(productName)) {
                    name.click();
                    productFound = true;
                    logger.info("Clicked on product: {}", productName);
                    break;
                }
            }

            if (!productFound) {
                logger.warn("Product with name '{}' was not found on the page.", productName);
            }

        } catch (Exception e) {
            logger.error("Error while clicking on product '{}': {}", productName, e.getMessage(), e);
        }
    }
}