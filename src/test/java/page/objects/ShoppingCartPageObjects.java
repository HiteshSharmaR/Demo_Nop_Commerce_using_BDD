package page.objects;

import org.openqa.selenium.By;

public class ShoppingCartPageObjects {

    public static final By SHOPPING_CART_TOP_MENU = By.cssSelector("div.header-links li#topcartlink");
    public static final By PRODUCT_NAME_IN_CART = By.cssSelector("td.product a");
    public static final By PRODUCT_QUANTITY_IN_CART = By.cssSelector(".product-quantity input");
}