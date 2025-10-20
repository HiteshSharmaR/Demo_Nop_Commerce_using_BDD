package page.objects;

import org.openqa.selenium.By;

public class LoginPageObjects {

    public static final By LOGIN_EMAIL = By.cssSelector(".inputs input.email");
    public static final By LOGIN_PASSWORD = By.cssSelector(".inputs input.password");
    public static final By LOGIN_BUTTON = By.cssSelector("div.returning-wrapper  div.buttons button.button-1");
}
