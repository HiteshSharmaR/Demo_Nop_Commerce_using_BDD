# Feature: Login Functionality

# As a user of the nopCommerce demo site,
# I want to be able to log in
# So that I can access my account and the restricted parts of the website.

Feature: User Login

  Background:
    Given  I am on the "http://localhost:5000" home page
    And I navigate to the "Log in" page
@login
  # --- Scenario 1: Successful Login ---
  Scenario: Successful Login with Valid Credentials
    When I enter a valid email "test@abc.com" into the email field
    And I enter a valid password "123456" into the password field
    And I click the on login button