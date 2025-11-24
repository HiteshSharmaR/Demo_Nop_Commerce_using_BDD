#Feature: Registration form.
#
#  Background:
#    Given I am on the "http://localhost:5000" home page
#
#  @Registration
#  Scenario: Successful registration with valid data
#    When I navigate to the "register" page
#    And I fill all the mandatory data
#    And I submit the registration form
#    Then I should see a confirmation message "Registration successful!"

  @Registration
  Feature: User Registration on nopCommerce (3-Step Format)

  Background:
    # Arrange: Set the context by navigating to the page
    Given I am on the "http://localhost:5000" home page

  # --- Scenario Outline for Successful Registration (Happy Path) ---
  Scenario Outline: Successful User Registration

    When I navigate to the "register" page
    # Arrange: Prepare the data and fill out the form (Setup)
    And I have entered valid registration details for "<Gender>", "<First Name>", "<Last Name>", "<Email>", "<Password>", "<Company Name>"

    # Act: Perform the action being tested (Execution)
    And I click the "Register" button

    # Assert: Verify the expected outcome (Verification)
    Then I should see the success message "Your registration completed"

    Examples:
      | Gender | First Name | Last Name | Email | Password |  Company Name   |
      | Male   | John       | Doe       | test@abc.com   | 123456  | -              |
      | Female | Jane       | Smith     | random@abc.com | 123456 | ACME Corp      |
      | Male   | Michael    | Scott     | abc@abc.com  | 123456  | Dunder Mifflin |