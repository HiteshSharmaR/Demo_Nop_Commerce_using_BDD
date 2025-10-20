package page.methods;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import page.objects.ProductDetailPageObject;

public class ProductDetailPageMethod {

    private static final Logger logger = LoggerFactory.getLogger(ProductDetailPageMethod.class);

    public static void addingProductToTheCart(WebDriver driver) {
        try {
            logger.info("Attempting to add product to the cart.");
            driver.findElement(ProductDetailPageObject.ADD_TO_CART_BUTTON).click();
            logger.info("Product successfully added to the cart.");
        } catch (Exception e) {
            logger.error("Error while adding product to the cart: {}", e.getMessage(), e);
        }
    }
}