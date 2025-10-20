package page.methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import page.objects.NavigationMenuObjects;
import page.steps.Hooks;

import java.time.Duration;
import java.util.List;

public class NavigationMenuMethods {

    private static final Logger logger = LoggerFactory.getLogger(NavigationMenuMethods.class);
    static WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(2000));

    public static void navigateToUrl(WebDriver driver, String URL) {
        try {
            logger.info("Navigating to URL: {}", URL);
            driver.get(URL);
            logger.info("Successfully navigated to: {}", URL);
        } catch (Exception e) {
            logger.error("Error while navigating to URL '{}': {}", URL, e.getMessage(), e);
        }
    }

    public static void interactWithMenu(WebDriver driver, String productCategory) {
        try {
            logger.info("Interacting with top-level menu: {}", productCategory);

            wait.until(ExpectedConditions.visibilityOfElementLocated(NavigationMenuObjects.MAIN_MENU));
            List<WebElement> menuItems = driver.findElements(NavigationMenuObjects.MAIN_MENU);

            boolean menuFound = false;
            for (WebElement item : menuItems) {
                if (item.getText().trim().equalsIgnoreCase(productCategory)) {
                    item.click();
                    logger.info("Clicked on menu item: {}", productCategory);
                    menuFound = true;
                    break;
                }
            }

            if (!menuFound) {
                logger.warn("Menu item '{}' was not found on the page.", productCategory);
            }

        } catch (Exception e) {
            logger.error("Error while interacting with menu '{}': {}", productCategory, e.getMessage(), e);
        }
    }

    public static void hoverOnMenuAndSelectCategory(WebDriver driver, String menuItems, String subMenuItem) {
        try {
            logger.info("Hovering over menu '{}' and selecting submenu '{}'", menuItems, subMenuItem);

            Actions actions = new Actions(driver);
            wait.until(ExpectedConditions.visibilityOfElementLocated(NavigationMenuObjects.MAIN_MENU));

            List<WebElement> topMenus = driver.findElements(NavigationMenuObjects.MAIN_MENU);
            boolean mainMenuFound = false;

            // Hover on main menu
            for (WebElement menu : topMenus) {
                if (menu.getText().equalsIgnoreCase(menuItems)) {
                    actions.moveToElement(menu).perform();
                    logger.info("Hovered over menu: {}", menuItems);
                    mainMenuFound = true;
                    break;
                }
            }

            if (!mainMenuFound) {
                logger.warn("Main menu '{}' not found.", menuItems);
                return;
            }

            // Click on submenu
            List<WebElement> subMenus = driver.findElements(NavigationMenuObjects.SUB_MENU);
            boolean subMenuFound = false;

            for (WebElement sub : subMenus) {
                if (sub.getText().equalsIgnoreCase(subMenuItem)) {
                    sub.click();
                    logger.info("Clicked on submenu item: {}", subMenuItem);
                    subMenuFound = true;
                    break;
                }
            }

            if (!subMenuFound) {
                logger.warn("Submenu '{}' not found under menu '{}'.", subMenuItem, menuItems);
            }

        } catch (Exception e) {
            logger.error("Error while hovering on menu '{}' or selecting submenu '{}': {}",
                    menuItems, subMenuItem, e.getMessage(), e);
        }
    }
}