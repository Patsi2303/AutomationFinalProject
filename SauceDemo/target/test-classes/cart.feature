Feature: Cart page

  Background: User login into Sauce Demo
    Given I am in sauce demo web page
    When I set the user name text box with "standard_user"
    And I set the password text box with "secret_sauce"
    And I click on the login button

  Scenario: Verify is possible to go back home from the cart
    When The home page should be displayed
    And I click on the cart button
    And I click on the continue-shopping button
    Then The home page should be displayed