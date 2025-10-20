# Feature File: nopcommerce_shopping_cart_e2e.feature

Feature: End-to-End Shopping Cart Workflow
  As a customer,
  I want to be able to add products to my cart,
  view and modify the items in the cart,
  and proceed to checkout.

  Background:
    # Setup steps that apply to all scenarios in this feature
    Given I am on the "http://localhost:5000" home page

  @e2e @checkout
  Scenario: Successful Purchase of a Single Product
    When I click on "Computers" and select "Notebooks"
    And I choose the product "Apple MacBook Pro"
    And I add the product to the shopping cart
    And I click on the add to cart button
    Then I should be on the "Your store. Shopping Cart" page
    And I should see the product "Apple MacBook Pro" listed in the cart
    And the Quantity for "Apple MacBook Pro" should be 2
    And the Sub-Total should be correct for one item

    # Cart Modification and Checkout
    When I update the Quantity for "Apple MacBook Pro 13-inch" to 3
    And I click the "Update shopping cart" button
    Then the Quantity for "Apple MacBook Pro 13-inch" should be 3
    And the Sub-Total should be correct for three items

    When I select the "I agree with the terms of service" checkbox
    And I click the "Checkout" button
    Then I should be navigated to the "Checkout" page

#  @cart_removal
#  Scenario: Removing a Product from the Cart
#    Given I have a product "Build your own computer" in my shopping cart
#    And I am on the "https://demo.nopcommerce.com/cart" page
#
#    When I click the "Remove" checkbox for the product "Build your own computer"
#    And I click the "Update shopping cart" button
#    Then I should see a message "Your Shopping Cart is empty!"
#    And the product "Build your own computer" should not be displayed in the cart table
#
#  @cart_empty
#  Scenario: Attempting to Checkout with an Empty Cart
#    Given I have an empty shopping cart
#    And I am on the "https://demo.nopcommerce.com/cart" page
#
#    When I select the "I agree with the terms of service" checkbox
#    And I click the "Checkout" button
#    Then I should see a warning message that prevents checkout
#    And I should remain on the "https://demo.nopcommerce.com/cart" page