package page.methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import page.objects.HeaderMenuObjects;
import page.steps.Hooks;

import java.time.Duration;
import java.util.List;

public class HeaderMenuMethods {

    private static final Logger logger = LoggerFactory.getLogger(HeaderMenuMethods.class);
    public static WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(2000));

    public static void clickOnHeaderMenu(WebDriver driver, String headerMenuName) {
        try {
            logger.info("Attempting to click on header menu: {}", headerMenuName);

            wait.until(ExpectedConditions.visibilityOfElementLocated(HeaderMenuObjects.HEADER_MENU));

            List<WebElement> headerMenus = driver.findElements(HeaderMenuObjects.HEADER_MENU);
            boolean menuFound = false;

            for (WebElement menu : headerMenus) {
                if (menu.getText().trim().equalsIgnoreCase(headerMenuName)) {
                    menu.click();
                    menuFound = true;
                    logger.info("Clicked on header menu: {}", headerMenuName);
                    break;
                }
            }

            if (!menuFound) {
                logger.warn("Header menu '{}' was not found on the page.", headerMenuName);
            }

        } catch (Exception e) {
            logger.error("Error while clicking on header menu '{}': {}", headerMenuName, e.getMessage(), e);
        }
    }
}