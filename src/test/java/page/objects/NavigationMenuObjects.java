package page.objects;

import org.openqa.selenium.By;

public class NavigationMenuObjects {

    public static final By MAIN_MENU = By.cssSelector("ul.top-menu.notmobile > li");
    public static final By SUB_MENU = By.cssSelector("ul.top-menu.notmobile > li:hover ul.sublist.first-level > li");
}
