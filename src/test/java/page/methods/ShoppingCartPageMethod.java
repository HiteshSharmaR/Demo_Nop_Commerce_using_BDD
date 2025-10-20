package page.methods;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import page.objects.ShoppingCartPageObjects;

public class ShoppingCartPageMethod {

    private static final Logger logger = LoggerFactory.getLogger(ShoppingCartPageMethod.class);

    public static void ClickOnShoppingCart(WebDriver driver){
        logger.info("Attempting to click the Shopping Cart link.");
        try {
            driver.findElement(ShoppingCartPageObjects.SHOPPING_CART_TOP_MENU).click();

            // Replaced System.out.println with logger.info
            logger.info("Navigated to Shopping Cart. Current page title: {}", driver.getTitle());

        } catch (Exception e) {
            logger.error("Error occurred while clicking Shopping Cart link: {}", e.getMessage(), e);
            Assert.fail("Failed to click on Shopping Cart: " + e.getMessage());
        }
    }

    public static void VerifyThatIAmOnShoppingCartPage(WebDriver driver,String expectedTitle){
        String actualTitle = null;
        try {
            actualTitle = driver.getTitle();
            logger.info("Verifying page title. Expected: '{}', Actual: '{}'", expectedTitle, actualTitle);

            Assert.assertEquals(actualTitle, expectedTitle,"It is not in correct page. Actual Title: " + actualTitle);

            logger.info("Successfully verified page title.");
        } catch (AssertionError e) {
            logger.error("Verification failed: Not on the expected page. Expected: '{}', Actual: '{}'", expectedTitle, actualTitle);
            throw e; // Re-throw assertion errors to fail the test
        } catch (Exception e) {
            logger.error("An unexpected error occurred during page title verification: {}", e.getMessage(), e);
            Assert.fail("Page title verification failed unexpectedly: " + e.getMessage());
        }
    }

    public static void VerifyThatRightProductIsInTheCart(WebDriver driver, String productName){
        String actualProductName = "";
        try {
            actualProductName = driver.findElement(ShoppingCartPageObjects.PRODUCT_NAME_IN_CART).getText();
            logger.info("Verifying product in cart. Expected: '{}', Actual: '{}'", productName, actualProductName);

            Assert.assertEquals(actualProductName ,productName,"It is not correct product. Actual Product: " + actualProductName);

            logger.info("Product verification successful for: {}", productName);
        } catch (AssertionError e) {
            logger.error("Verification failed: Wrong product in cart. Expected: '{}', Actual: '{}'", productName, actualProductName);
            throw e;
        } catch (Exception e) {
            logger.error("An unexpected error occurred during product verification: {}", e.getMessage(), e);
            Assert.fail("Product verification failed unexpectedly: " + e.getMessage());
        }
    }

    public static void VerifyTheQuantityInCart(WebDriver driver, String productName, int expectedQuantity){
        try {
            logger.debug("Attempting to get quantity size/dimension for product: {}", productName);
            logger.debug("Element dimension/size: {}", driver.findElement(ShoppingCartPageObjects.PRODUCT_QUANTITY_IN_CART).getSize());
            logger.warn("Quantity verification assertion is commented out or incomplete. Expected quantity: {}", expectedQuantity);

        } catch (Exception e) {
            logger.error("Error occurred while verifying quantity for product {}: {}", productName, e.getMessage(), e);
            Assert.fail("Quantity verification failed: " + e.getMessage());
        }
    }
}