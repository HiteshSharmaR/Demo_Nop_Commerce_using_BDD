package page.objects;

import org.openqa.selenium.By;

public class RegistrationPageObjects {

    public static final By GENDER_MALE_RADIO_BUTTON = By.cssSelector("div.inputs span.male input");
    public static final By GENDER_FEMALE_RADIO_BUTTON = By.cssSelector("div.inputs span.female input");
    public static final By FIRST_NAME_INPUT = By.cssSelector("div.inputs input#FirstName");
    public static final By LAST_NAME_INPUT = By.cssSelector("div.inputs input#LastName");
    public static final By EMAIL_INPUT = By.cssSelector("div.inputs input#Email");
    public static final By COMPANY_NAME = By.cssSelector("div.inputs input#Company");
    public static final By PASSWORD_INPUT = By.cssSelector("div.inputs input#Password");
    public static final By CONFIRM_PASSWORD_INPUT = By.cssSelector("div.inputs input#ConfirmPassword");
    public static final By REGISTER_BUTTON = By.cssSelector("#register-button");
}