Feature: Checkout feature

  Background: User should be able to do a checkout
    Given I am in sauce demo web page
    When I set the user name text box with "standard_user"
    And I set the password text box with "secret_sauce"
    And I click on the login button

    Scenario: Verify that is possible to cancel checkout
      Given The home page should be displayed
      When I add to the cart the product "Sauce Labs Backpack"
      And I click on the cart button
      And I click on the checkout button
      And I click on the cancel button
      Then The title of the cart should be displayed

    Scenario: Verify that is not possible to checkout without complete information
      Given The home page should be displayed
      When I add to the cart the product "Sauce Labs Backpack"
      And I click on the cart button
      And I click on the checkout button
      And I fill the checkout information with
        | Alejandro | Uriarte |
      And I click on the continue button
      Then A error message that says "Error: Postal Code is required" should be displayed
