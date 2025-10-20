package page.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import page.methods.ComputersPageMethods;
import page.methods.NavigationMenuMethods;
import page.methods.ProductDetailPageMethod;
import page.methods.ShoppingCartPageMethod;

public class NopCommerceShoppingCartSteps {
    private WebDriver driver;

    public NopCommerceShoppingCartSteps() {
        driver = Hooks.driver;
    }

    @Given("I am on the {string} home page")
    public void i_am_on_the_home_page(String URL) {
        NavigationMenuMethods.navigateToUrl(driver, URL);
    }

    @When("I click on {string} and select {string}")
    public void i_click_on_and_select(String mainMenu, String subMenu) {
        NavigationMenuMethods.hoverOnMenuAndSelectCategory(driver, mainMenu, subMenu);
    }

    @And("I choose the product {string}")
    public void i_choose_the_product(String productName) {
        ComputersPageMethods.clickOnProductName(driver, productName);
    }

    @And("I add the product to the shopping cart")
    public void i_add_the_product_to_the_shopping_cart() {
        ProductDetailPageMethod.addingProductToTheCart(driver);
    }

    @And("I click on the add to cart button")
    public void i_click_on_the_add_to_cart_button() {
        ShoppingCartPageMethod.ClickOnShoppingCart(driver);
    }

    @Then("I should be on the {string} page")
    public void i_should_be_on_the_page(String shoppingCartPageTitle) {
        ShoppingCartPageMethod.VerifyThatIAmOnShoppingCartPage(driver, shoppingCartPageTitle);
    }

    @And("I should see the product {string} listed in the cart")
    public void i_should_see_the_product_listed_in_the_cart(String productName) {
        ShoppingCartPageMethod.VerifyThatRightProductIsInTheCart(driver, productName);
    }

    @And("the Quantity for {string} should be {int}")
    public void the_quantity_for_should_be(String string, Integer int1) {
        ShoppingCartPageMethod.VerifyTheQuantityInCart(driver, string, int1);
    }

    @And("the Sub-Total should be correct for one item")
    public void the_sub_total_should_be_correct_for_one_item() {
    }

    @When("I update the Quantity for {string} to {int}")
    public void i_update_the_quantity_for_to(String string, Integer int1) {
    }

    @And("I click the {string} button")
    public void i_click_the_button(String string) {
    }

    @Then("the Sub-Total should be correct for three items")
    public void the_sub_total_should_be_correct_for_three_items() {
    }

    @And("I select the {string} checkbox")
    public void i_select_the_checkbox(String string) {
    }

    @Then("I should be navigated to the {string} page")
    public void i_should_be_navigated_to_the_page(String string) {
    }
}
